package com.dimple.fileuploaddownload;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Mytest
 *
 * @author BianXiaofeng
 * @date 12/23/2022 5:23 PM
 */
public class MyTest {

    private void func() {
        synchronized (MyTest.class){
            for (int i = 0; i < 100; i++) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    private Lock lock = new ReentrantLock();
    private void function() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }finally {
            lock.unlock();
        }
    }
    @Test
    public void test1() {
        MyTest myTest = new MyTest();
        MyTest myTest1 = new MyTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> myTest.function());
        executorService.execute(() -> myTest1.function());
    }
}
