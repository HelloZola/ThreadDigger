package com.dig.demo.dig_demo.guard_thread;

import com.dig.utils.TimeUtil;

/**
 * @author 作者 E-mail:
 * @version 创建时间：${date} ${time}
 * 类说明
 */
public class GuardThread implements Runnable {
    @Override
    public void run() {
        while (true){
            try {
                System.out.println("我是守护线程，我正在运行呢......."+ TimeUtil.getDefaultNowTime());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
