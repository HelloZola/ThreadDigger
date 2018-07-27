package com.dig.lock_demo.reenrrantlock;

public class MyThread extends Thread{

    private MyService myservice;

    public MyThread(MyService service){

        myservice = service;
    }

    public void run(){
        myservice.testMethod();
    }

    public static void main(String[] args) {
        MyService service = new MyService();
        new MyThread(service).start();
        new MyThread(service).start();
        new MyThread(service).start();
        new MyThread(service).start();
    }


}
