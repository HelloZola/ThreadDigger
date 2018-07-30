package com.dig.currentPackage.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * 学生任务
 */
public class StudentTask extends Thread {

    private Phaser phaser;

    public StudentTask(Phaser phaser_) {
        this.phaser = phaser_;
    }

    @Override
    public void run() {
        this.arriveAndReady();
        this.finishFirstExam();
        this.finishSecondExam();
        this.finishThirdExam();
        this.goHome();
    }

    /**
     * 学生到达,准备考试
     */
    public void arriveAndReady() {
        Random random = new Random();
        int i1 = random.nextInt(9) + 1;
        try {
            TimeUnit.SECONDS.sleep(i1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "到达考试,用了时间：" + i1 + " s");
        phaser.arriveAndAwaitAdvance();
    }

    /**
     * 完成第一题
     */
    public void finishFirstExam() {
        Random random = new Random();
        int i1 = random.nextInt(9) + 1;
        try {
            TimeUnit.SECONDS.sleep(i1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "完成了第一题,用了时间：" + i1 + " s");
        phaser.arriveAndAwaitAdvance();
    }

    /**
     * 完成第二题
     */
    public void finishSecondExam() {
        Random random = new Random();
        int i1 = random.nextInt(9) + 1;
        try {
            TimeUnit.SECONDS.sleep(i1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "完成了第二题，用了时间：" + i1 + " s");
        phaser.arriveAndAwaitAdvance();
    }

    /**
     * 完成第三题
     */
    public void finishThirdExam() {
        Random random = new Random();
        int i1 = random.nextInt(9) + 1;
        try {
            TimeUnit.SECONDS.sleep(i1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "完成了第三题,用了时间：" + i1 + " s");
        phaser.arriveAndAwaitAdvance();
    }

    /**
     * 回家了
     */
    public void goHome() {
        System.out.println(Thread.currentThread().getName() + "回家了!");
        phaser.arriveAndAwaitAdvance();
    }

}
