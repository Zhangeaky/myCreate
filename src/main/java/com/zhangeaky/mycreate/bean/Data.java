package com.zhangeaky.mycreate.bean;

import lombok.Getter;

public class Data {

    @Getter
    private static int count;

    private static Object locker = new Object();

    public static int reset() {
        count = 0;
        return count;
    }

    /**
     *  在非静态的wrong 方法上加锁
     *  只能确保多线程无法同事执行该实例的wrong 方法
     */
    public synchronized void wrong() {
        count++;
    }

    public void right() {

        synchronized (locker){
            count++;
        }
    }
}
