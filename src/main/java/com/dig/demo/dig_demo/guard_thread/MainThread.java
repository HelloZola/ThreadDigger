package com.dig.demo.dig_demo.guard_thread;

import com.dig.utils.TimeUtil;

/**
 * @author 作者 E-mail:
 * @version 创建时间：${date} ${time}
 * 类说明
 */
public class MainThread{

    public void run(){
        System.out.println("我现在要创建守护线程...");
        new Thread(new GuardThread()).start();
        System.out.println("我是主线程，我正在运行..."+ TimeUtil.getDefaultNowTime());
        try {
            Thread.sleep(10000);
            System.out.println("我是主线程，我正在运行..."+ TimeUtil.getDefaultNowTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Thread mainThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread thread = new Thread(new GuardThread());
                thread.setDaemon(true);
                thread.start();
                System.out.println("我是主线程，我正在运行中...");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我是主线程，我现在结束运行...");
            }
        });
        mainThread.start();

    }


}
