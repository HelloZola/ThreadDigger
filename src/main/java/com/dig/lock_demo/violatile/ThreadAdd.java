package com.dig.lock_demo.violatile;

public class ThreadAdd extends Thread{

    private ViolatileDemo violatileDemo;

    public ThreadAdd(ViolatileDemo violatileDemo_) {
        this.violatileDemo = violatileDemo_;
    }

    public void run(){
        for (int i=0;i<20;i++){
            System.out.println("获取当前i值："+violatileDemo.add());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
