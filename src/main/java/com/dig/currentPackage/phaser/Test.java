package com.dig.currentPackage.phaser;

public class Test {

    public static void main(String[] args) {

        PhaserDemo phaserDemo = new PhaserDemo();
        StudentTask[] studentTasks = new StudentTask[5];

        for (int i=0;i<5;i++){
            studentTasks[i] = new StudentTask(phaserDemo);
            phaserDemo.register();
        }

        for (StudentTask studentTask: studentTasks) {
            studentTask.start();
        }
    }

}
