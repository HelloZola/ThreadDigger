package com.dig.demo.pool_demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 作者 E-mail:
 * @version 创建时间：${date} ${time}
 * 类说明
 */
public class NewWorkStealingPoolDemo {

    private static NewWorkStealingPoolDemo newWorkStealingPoolDemo = null;

    ExecutorService executorService = null;

    private NewWorkStealingPoolDemo() {
        if (executorService == null) {
            executorService = Executors.newWorkStealingPool();
        }
    }

    private NewWorkStealingPoolDemo(int parallelism) {
        if (executorService == null) {
            executorService = Executors.newWorkStealingPool(parallelism);
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

    public static NewWorkStealingPoolDemo getThreadPoolInstWithThreadFactory() {
        synchronized (NewWorkStealingPoolDemo.class) {
            if (newWorkStealingPoolDemo == null) {
                newWorkStealingPoolDemo = new NewWorkStealingPoolDemo();
            }
            return newWorkStealingPoolDemo;
        }
    }

    public static NewWorkStealingPoolDemo getThreadPoolInstWithThreadFactory(int parallelism) {
        synchronized (NewWorkStealingPoolDemo.class) {
            if (newWorkStealingPoolDemo == null) {
                newWorkStealingPoolDemo = new NewWorkStealingPoolDemo(parallelism);
            }
            return newWorkStealingPoolDemo;
        }
    }


}
