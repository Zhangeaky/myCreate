package com.zhangeaky.mycreate.thread;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
public class ThreadLocalController {
    static class Request {
        String id;

        String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @RequestMapping("/t1")
    String test01(@RequestBody Request request) throws Exception{

        RunContext context = new RunContext();
        context.setId(request.getId());
        context.setName(request.getName());
        context.setNum(Thread.currentThread().getName());
        RunContextHolder.set(context);
        String x =  RunContextHolder.get().toString();
        Thread.sleep(10_000);
        RunContextHolder.clear();
        //RunContextHolderr
        return x;
    }

    @RequestMapping("/peek")
    String test02() {

        RunContext context = RunContextHolder.get();
        return context.toString();
    }

    public static ExecutorService es = new ThreadPoolExecutor(10, 10,
            60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));

    public Integer invokeTimes = 0;

    public Integer copy = 0;


    @RequestMapping("/invoke")
    String test03() {

        es.execute(new Runnable() {
            @Override
            public void run() {
                invokeTimes++;
                copy++;
                System.out.println("worker" + Thread.currentThread().getName());
            }
        });

        return String.valueOf(invokeTimes.equals(copy));
    }
}
