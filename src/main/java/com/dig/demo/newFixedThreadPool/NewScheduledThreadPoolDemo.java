package com.dig.demo.newFixedThreadPool;

import java.util.concurrent.*;

/**
 * @author 作者 E-mail:
 * @version 创建时间：${date} ${time}
 * 类说明
 */
public class NewScheduledThreadPoolDemo {

    private final static int core_thread_size = 2;

    private static NewScheduledThreadPoolDemo newScheduledThreadPoolDemo = null;

    ScheduledExecutorService executorService = null;

    private NewScheduledThreadPoolDemo() {
        if (executorService == null) {
            executorService = Executors.newScheduledThreadPool(core_thread_size);
        }
    }

    private NewScheduledThreadPoolDemo(ThreadFactory threadFactory) {
        if (executorService == null) {
            executorService = Executors.newScheduledThreadPool(core_thread_size,threadFactory);
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

    /**
     * 执行任务
     */
    public void execute(Runnable task,int initialDelay,int period) {
        try {
            System.out.println("增加了任务...");
            executorService.scheduleAtFixedRate(task,initialDelay,period, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static NewScheduledThreadPoolDemo getThreadPoolInstWithThreadFactory(ThreadFactory threadFactory) {
        synchronized (NewScheduledThreadPoolDemo.class) {
            if (newScheduledThreadPoolDemo == null) {
                newScheduledThreadPoolDemo = new NewScheduledThreadPoolDemo(threadFactory);
            }
            return newScheduledThreadPoolDemo;
        }
    }


}
