package com.dig.lock_demo.condition;


import java.util.Date;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class ConditionDemo {

    private Lock lock = new ReentrantLock();

    private Condition pullConditon = lock.newCondition();
    //插入条件
    final Condition insertCondtion = lock.newCondition();
    //拉取条件
    final Condition pullCondition = lock.newCondition();

    private ConcurrentLinkedQueue<String> deque = new ConcurrentLinkedQueue<String>();

    public void insert() {
        System.out.println("开始运行insert..." + Thread.currentThread().getName());
        lock.lock();
        System.out.println("我获取到锁了..."+ Thread.currentThread().getName());
        try {
            while (deque.size() > 2) {
                System.out.println("内容太多了，不要再插进去了，我要开始休息了..." + Thread.currentThread().getName());
                insertCondtion.await();
            }
            String content = new Date().getTime() + "";
            System.out.println("我要插入内容：" + content);
            deque.add(content);
            pullCondition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("我要释放锁了..."+Thread.currentThread().getName());
            lock.unlock();
        }
    }

    public void pull() {
        System.out.println("开始运行pull..." + Thread.currentThread().getName());
        lock.lock();
        System.out.println("我获取到锁了..."+ Thread.currentThread().getName());
        try {
            while (deque.size() <= 0) {
                System.out.println("已经没东西可以拉取了，我要进入等待队列..." + Thread.currentThread().getName());
                insertCondtion.signalAll();
                pullCondition.await();
            }
            System.out.println("我要开始拉取内容...");
            String content = deque.poll();
            if (content == null) {
                //todo
            } else {
                System.out.println(Thread.currentThread().getName() + "获取到内容：" + content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("我要释放锁了..."+Thread.currentThread().getName());
            lock.unlock();
        }
    }

}
