package com.dig.lock_demo.condition;

public class InsertThread extends Thread {

    ConditionDemo conditionDemo;

    public InsertThread(ConditionDemo conditiondemo_) {
        this.conditionDemo = conditiondemo_;
    }

    public void run() {
        conditionDemo.insert();
    }

}
