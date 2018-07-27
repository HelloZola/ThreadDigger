package com.dig.lock_demo.condition;

public class Test {

    public static void main(String[] args) {

        ConditionDemo conditionDemo = new ConditionDemo();
        new PollThread(conditionDemo).start();
        new InsertThread(conditionDemo).start();
    }

}
