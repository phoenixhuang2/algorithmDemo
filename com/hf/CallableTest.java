package com.hf;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author huangfeng
 * @Date: Created in 8:45 下午 2020/11/30
 * @Description
 **/
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread());
        Thread thread = new Thread(futureTask, "AA");
        thread.start();

        System.out.println(Thread.currentThread().getName()+" ******Main*****");
        int result1 = 100;
        int result2 = futureTask.get();
        System.out.println(Thread.currentThread().getName()+" ******GET*****"+(result1+result2));

        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" ********Callable****");
        TimeUnit.SECONDS.sleep(2);
        return 1024;
    }
}


class MyThread2 implements Runnable {

    @Override
    public void run() {

    }
}