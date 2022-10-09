package com.zhangeaky.mycreate.controller;

import com.zhangeaky.mycreate.bean.Data;
import com.zhangeaky.mycreate.bean.Item;
import com.zhangeaky.mycreate.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintStream;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class LockerWrongController {

    @Autowired
    Person person;

    @RequestMapping("resouce")
    public  String resource() {
        System.out.println("[test]: " + person);
        return "";

    }

    @RequestMapping("lock/wrong")
    public Integer wrong(@RequestParam(value = "count", defaultValue = "100000") int count) {

        System.out.println("[count] " + count);
        Data.reset();

        Data model = new Data();

        IntStream.rangeClosed(0, count).parallel().forEach(x -> new Data().right());
        return Data.getCount();
    }

    private static Map<String, Item> items = new HashMap<>();
    static {
        items.put("item0", new Item("篮球"));
        items.put("item1", new Item("手机"));
        items.put("item2", new Item("深入理解Java虚拟机"));
    }


    private List<Item> createCart() {
        return IntStream.rangeClosed(1, 3)
                .mapToObj(i -> "item" + ThreadLocalRandom.current().nextInt(items.size()))
                .map(name -> items.get(name))
                .sorted(Comparator.comparing(Item::getName)) // 正确与否的关键
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        LockerWrongController controller = new LockerWrongController();
        controller.createCart().stream().forEach(System.out::println);
    }

    /**
     *
     * 重点关注的代码
     *
     * @param order
     * @return
     */
    private boolean createOrder(List<Item> order) {

        List<ReentrantLock> locks = new ArrayList<>();

        for (Item item : order) {

            try {
                if (item.lock.tryLock(10, TimeUnit.SECONDS)) {
                    locks.add(item.lock);
                } else {
                    locks.forEach(ReentrantLock::unlock);
                    return false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 拿到全部的商品的锁
        try {
            order.forEach(x -> x.remaining--);
        }finally {
            locks.forEach(ReentrantLock::unlock);
        }

        return true;
    }

    @GetMapping("wrong/buy")
    public long wrongBuy() {
        long begin = System.currentTimeMillis();
        //并发进行100次下单操作，统计成功次数
        long success = IntStream.rangeClosed(1, 100).parallel()
                .mapToObj(i -> {
                    List<Item> cart = createCart();
                    return createOrder(cart);
                })
                .filter(result -> result)
                .count();

        PrintStream format = System.out.format("success:%s totalRemaining:%s took:%s ms items:%s",
                success,
                items.entrySet().stream().map(item -> item.getValue().remaining).reduce(0, Integer::sum),
                System.currentTimeMillis() - begin, items);
        format.println();
        return success;
    }

}
