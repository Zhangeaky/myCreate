package com.zhangeaky.mycreate.controller;

import com.zhangeaky.mycreate.bean.Person;
import com.zhangeaky.mycreate.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@RestController
public class testController {

    @Autowired
    Person person;

    static {
        System.out.println("******************");
    }

    private static final ThreadLocal<User> context = ThreadLocal.withInitial(()->null);

    private static int ITEM = 1000;

    private static int COUNT = 10;


    @RequestMapping("hello")
    public String wrong(@RequestBody User user) {
        System.out.println("[test]: " + person);

        String before =  Thread.currentThread().getName() + " " +context.get();
        Map<String, String> result = new HashMap<String, String>();

        context.set(user);

        result.put("before", before);

        String after = Thread.currentThread().getName() + " " + context.get();
        result.put("after", after);

        context.remove();
        return String.valueOf(result);

    }

    private ConcurrentHashMap<String, Long> getData(int count) {

        return LongStream.rangeClosed(1, count)
                .boxed()
                .collect(Collectors.toConcurrentMap(i-> UUID.randomUUID().toString(),
                        Function.identity(), (o1, o2)-> o1, ConcurrentHashMap::new));

    }

    @RequestMapping("yida")
    public String error() throws InterruptedException {
        System.out.println("[test]: " + person);

        ConcurrentHashMap<String, Long> concurrentHashMap = getData(ITEM-100);

        System.out.println("init size of hashmap: " + concurrentHashMap.size());
    ForkJoinPool pool = new ForkJoinPool(COUNT);

    pool.execute(() ->{
        IntStream.rangeClosed(0, 9).parallel().forEach(x->{
            synchronized (concurrentHashMap) {
                System.out.println("para : " + Thread.currentThread().getName());
                int gap = ITEM - concurrentHashMap.size();
                System.out.println("gap size is: " + gap);
                concurrentHashMap.putAll(getData(gap));
            }
        });
    });

    pool.shutdown();
    pool.awaitTermination(1, TimeUnit.HOURS);

    System.out.println("size finally" + concurrentHashMap.size());

    return "ok";

    }
}
