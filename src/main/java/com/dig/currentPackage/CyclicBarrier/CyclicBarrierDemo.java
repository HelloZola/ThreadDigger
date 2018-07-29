package com.dig.currentPackage.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("全部都到齐了!");
            }
        });

        for (int i = 0; i < 6; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        java.util.Random random=new java.util.Random();
                        int result=random.nextInt(10);
                        Thread.sleep(result);
                        System.out.println("我到了"+Thread.currentThread().getName());
                        cyclicBarrier.await();
                        System.out.println("大家都到了，我可以动了....");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
