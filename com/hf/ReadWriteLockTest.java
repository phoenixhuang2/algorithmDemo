package com.hf;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author huangfeng
 * @Date: Created in 12:29 下午 2020/11/27
 * @Description
 **/
public class ReadWriteLockTest {
    public static void main(String[] args) {
        Mycache mycache = new Mycache();
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(()->{
                mycache.put(temp+"", temp+"");
            }, "thread"+i).start();
        }

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(()->{
                mycache.get(temp+"");
            }, "thread"+i).start();
        }
    }
}


class Mycache {
    private volatile Map<String, String> cache = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    public void put(String key, String val) {
        lock.writeLock().lock();
        try {
            System.out.println(key+" 准备写入");
            try {
                TimeUnit.MILLISECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cache.put(key, val);
            System.out.println(key+" 写入完成");
        } finally {
            lock.writeLock().unlock();
        }
    }
    public void get(String key) {
        lock.readLock().lock();
        try {
            System.out.println(key+" 准备读取");
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cache.get(key);
            System.out.println(key+" 读取完成");
        } finally {
            lock.readLock().unlock();
        }
    }
}