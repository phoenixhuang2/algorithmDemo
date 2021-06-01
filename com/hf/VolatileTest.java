package com.hf;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.*;


public class VolatileTest {
    public static void main(String[] args) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.get(1);
        copyOnWriteArrayList.subList(0, 4);

//        Collections.synchronizedSet()
    }

    public void testVolatile() {
        MyData myData = new MyData();
        new Thread(()->{
            System.out.println(myData.num);
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.add();
            System.out.println(Thread.currentThread().getName() + " thread num ="+myData.num);
        }, "Thread1").start();

        while (myData.num == 0) {
            //
        }
        System.out.println("main thread num = "+myData.num);
    }
}

class MyData {
    volatile int num = 0;
    public void add() {
        num = 60;
    }

    AtomicInteger ai = new AtomicInteger();
    public void addMyAto() {
        ai.getAndIncrement();
    }



}
