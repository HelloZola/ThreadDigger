package com.dig.lock_demo.reenrrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private ReentrantLock lock = new ReentrantLock();

    public void testMethod() {

        try {
            System.out.println("我开始跑了..." + Thread.currentThread().getName());
            lock.lock();
            System.out.println("我获取到了锁 " + Thread.currentThread().getName());
            System.out.println("现在我要休息3秒...");
            Thread.sleep(3000);
            System.out.println("好了，我休息完了，我准备释放锁");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
