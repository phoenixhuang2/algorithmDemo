package com.hf;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author huangfeng
 * @Date: Created in 11:43 上午 2020/11/27
 * @Description 自旋锁实现
 **/
public class SpinLockTest {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+" invoke lock");
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+" un lock");
        while (!atomicReference.compareAndSet(thread, null)) {

        }
    }

    public static void main(String[] args) {
        SpinLockTest spinLockTest = new SpinLockTest();
        new Thread(()->{
            spinLockTest.myLock();

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            spinLockTest.myUnLock();

        }, "thread1").start();


        new Thread(()->{
            spinLockTest.myLock();
            spinLockTest.myUnLock();
        }, "thread2").start();
    }
}
