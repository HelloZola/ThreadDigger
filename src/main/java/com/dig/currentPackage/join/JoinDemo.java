package com.dig.currentPackage.join;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class JoinDemo {

    public static void main(String[] args) {

        Mythread mythread1 = new Mythread(10);
        Mythread mythread2 = new Mythread(2);
        mythread1.start();
        try {
            mythread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mythread2.start();
    }

    static class Mythread extends Thread{

        private long sleep_time = 0;
        public Mythread(long sleep_time_){
            this.sleep_time = sleep_time_;
        }

        @Override
        public void run(){
            try {
                TimeUnit.SECONDS.sleep(sleep_time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"完成！用时："+sleep_time);
        }
    }
}
