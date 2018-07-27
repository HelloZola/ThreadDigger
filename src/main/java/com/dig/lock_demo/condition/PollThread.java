package com.dig.lock_demo.condition;

public class PollThread extends Thread {

    ConditionDemo conditionDemo;

    public PollThread(ConditionDemo conditiondemo_) {
        this.conditionDemo = conditiondemo_;
    }

    public void run() {
        conditionDemo.pull();
    }

}
