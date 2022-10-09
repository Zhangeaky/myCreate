package com.zhangeaky.mycreate.bean;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

@Data
@RequiredArgsConstructor
public class Item {

    final String name;
    public int remaining = 1000;

    @ToString.Exclude
    public ReentrantLock lock = new ReentrantLock();

}
