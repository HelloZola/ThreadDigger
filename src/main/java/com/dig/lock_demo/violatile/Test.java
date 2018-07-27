package com.dig.lock_demo.violatile;

public class Test {

    public static void main(String[] args) {
        ViolatileDemo violatileDemo = new ViolatileDemo();
        new ThreadRead(violatileDemo).start();
        new ThreadAdd(violatileDemo).start();
    }

}
