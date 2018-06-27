package com.dig.demo.newFixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * NewFixedThreadPool demo
 */
public class NewFixedThreadPoolDemo {

    private static NewFixedThreadPoolDemo newFixedThreadPoolDemo = null;

    ExecutorService executorService = null;

//    private final static int nThreads = Runtime.getRuntime().availableProcessors();
    private final static int nThreads = 2;

    private NewFixedThreadPoolDemo(int num) {
        if (executorService == null) {
            System.out.println("允许最大线程数：" + num);
            executorService = Executors.newFixedThreadPool(num);
        }
    }

    private NewFixedThreadPoolDemo(int num, ThreadFactory threadFactory) {
        if (executorService == null) {
            System.out.println("允许最大线程数：" + num);
            executorService = Executors.newFixedThreadPool(num, threadFactory);
        }
    }

    public static NewFixedThreadPoolDemo getThreadPoolInst() {
        synchronized (NewFixedThreadPoolDemo.class) {
            if (newFixedThreadPoolDemo == null) {
                newFixedThreadPoolDemo = new NewFixedThreadPoolDemo(nThreads);
            }
            return newFixedThreadPoolDemo;
        }
    }

    /**
     * 执行任务
     */
    public void execute(Runnable task) {
        try {
            System.out.println("增加了任务...");
            executorService.execute(task);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
