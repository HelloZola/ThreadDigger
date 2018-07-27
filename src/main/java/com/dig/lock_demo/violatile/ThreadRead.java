package com.dig.lock_demo.violatile;

public class ThreadRead extends Thread{

    private ViolatileDemo violatileDemo;

    public ThreadRead(ViolatileDemo violatileDemo_) {
        this.violatileDemo = violatileDemo_;
    }

    public void run(){
        for (int i=0;i<30;i++){
            violatileDemo.read();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
