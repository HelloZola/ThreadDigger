package com.dig.currentPackage.phaser;

import java.util.concurrent.Phaser;

public class PhaserDemo extends Phaser {

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {    //在每个阶段执行完成后回调的方法
        switch (phase) {
            case 0:
                String result = "学生都已经全部到达，学生人数：" + registeredParties;
                System.out.println(result);
                return false;//当return true，那么线程就不再受限，Phase不再起分段效果
            case 1:
                result = "学生都全部完成了第一个测试";
                System.out.println(result);
                return false;
            case 2:
                result = "学生都全部完成了第二个测试";
                System.out.println(result);
                return false;
            case 3:
                result = "学生都全部完成了所有的测试";
                System.out.println(result);
                return false;
            default:
                System.out.println("学生都全部走了");
                return true;
        }
    }

}
