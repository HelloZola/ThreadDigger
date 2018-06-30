package com.dig.demo.newFixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author 作者 E-mail:
 * @version 创建时间：${date} ${time}
 * 类说明
 */
public class NewSingleThreadPoolDemo {

    private final static int core_thread_size = 2;

    private static NewSingleThreadPoolDemo newSingleThreadExecutorDemo = null;

    ExecutorService executorService = null;

    private NewSingleThreadPoolDemo() {
        if (executorService == null) {
            executorService = Executors.newScheduledThreadPool(core_thread_size);
        }
    }

    private NewSingleThreadPoolDemo(ThreadFactory threadFactory) {
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

    public static NewSingleThreadPoolDemo getThreadPoolInstWithThreadFactory(ThreadFactory threadFactory) {
        synchronized (NewSingleThreadPoolDemo.class) {
            if (newSingleThreadExecutorDemo == null) {
                newSingleThreadExecutorDemo = new NewSingleThreadPoolDemo(threadFactory);
            }
            return newSingleThreadExecutorDemo;
        }
    }


}
