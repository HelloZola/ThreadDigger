package com.dig.lock_demo.violatile;

public class ViolatileDemo {

    volatile private int i = 0;

    public int add(){
        return ++i;
    }

    public void read(){
        System.out.println("当前i值："+i);
    }

}
