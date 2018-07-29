package com.dig.currentPackage.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo2 {

    private CountDownLatch countDownLatch = new CountDownLatch(5);

    public void testMethod() {

        try {
            System.out.println("开始等待...");
            countDownLatch.await();
            System.out.println("结束等待...");
//            countDownLatch.await(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void countDelete() {
        countDownLatch.countDown();
    }

    public static void main(String[] args) {

        CountDownLatchDemo2 countDownLatchDemo = new CountDownLatchDemo2();

        for (int i=0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    countDownLatchDemo.testMethod();
                }
            }).start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    try {
                        i++;
                        countDownLatchDemo.countDelete();
                        System.out.println("递减...");
                        Thread.sleep(2000);
                        if (i > 7) {
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
