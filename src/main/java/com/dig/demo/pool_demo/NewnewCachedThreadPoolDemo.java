package com.dig.demo.pool_demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author 作者 E-mail:
 * @version 创建时间：${date} ${time}
 * 类说明
 */
public class NewnewCachedThreadPoolDemo {

    private static NewnewCachedThreadPoolDemo newnewCachedThreadPoolDemo = null;

    ExecutorService executorService = null;


    private NewnewCachedThreadPoolDemo() {
        if (executorService == null) {
            executorService = Executors.newCachedThreadPool();
        }
    }

    private NewnewCachedThreadPoolDemo(ThreadFactory threadFactory) {
        if (executorService == null) {
            executorService = Executors.newCachedThreadPool(threadFactory);
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

    public static NewnewCachedThreadPoolDemo getThreadPoolInstWithThreadFactory(ThreadFactory threadFactory) {
        synchronized (NewnewCachedThreadPoolDemo.class) {
            if (newnewCachedThreadPoolDemo == null) {
                newnewCachedThreadPoolDemo = new NewnewCachedThreadPoolDemo(threadFactory);
            }
            return newnewCachedThreadPoolDemo;
        }
    }

}
