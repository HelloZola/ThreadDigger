package com.dig.demo.pool_demo;

import java.util.concurrent.ThreadFactory;

/**
 * @author 作者 E-mail:
 * @version 创建时间：${date} ${time}
 * 类说明
 */
public class MyThreadFactory implements ThreadFactory {

    private int count = 1;

    public Thread newThread(Runnable r) {
        int cur_count = count++;
        System.out.println("我是线程工厂，我正在生产线程：" + cur_count);
        Thread thread = new Thread(r);
        thread.setName("我是线程"+cur_count);
        return thread;
    }
}
