package com.hf;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author huangfeng
 * @Date: Created in 3:56 下午 2020/11/28
 * @Description
 **/
public class LockConditionTest {
    public static void main(String[] args) {
//        MyMoney myMoney = new MyMoney();
        BoundedBuffer boundedBuffer = new BoundedBuffer();

        new Thread(()->{
//            myMoney.earn();
            try {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "开始生产");
                    boundedBuffer.put(new Random(100));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{

            try {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "开始消费");
                    boundedBuffer.put(new Random(10));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            myMoney.pay();
        }).start();

    }
}

class BoundedBuffer {
    final Lock lock = new ReentrantLock();
    final Condition notFull  = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
//                notFull.await();
            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
//            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
//            while (count == 0)
//                notEmpty.await();
            Object x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
//            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}


class MyMoney {
    Lock lock = new ReentrantLock();
    private volatile AtomicInteger money;
    Condition earnCondition = lock.newCondition();
    Condition payCondition = lock.newCondition();

    public MyMoney() {
        this.money = money;
        money = new AtomicInteger();
        money.set(10);
    }

    public void earn() {
        lock.lock();
        try {
            while (money.get() != 0) {
                earnCondition.await();
            }
            while (money.get() == 0) {
                System.out.println(Thread.currentThread().getName() + "赚到钱了，快来花吧");
                money.incrementAndGet();
                payCondition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void pay() {
        lock.lock();
        try {
            while (money.get() == 0) {
                payCondition.await();
            }
            while (money.get() > 0) {
                System.out.println(Thread.currentThread().getName() + " 花完啦，赶紧赚");
                money.decrementAndGet();
                earnCondition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
