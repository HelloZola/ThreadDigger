package com.dig.currentPackage.compleService.noCompletionServiceDemo;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class NoCompletionServiceDemo {


    static class CallabelTask implements Callable {

        @Override
        public Object call() throws Exception {
            Random random = new Random();
            int i1 = random.nextInt(9) + 1;
            TimeUnit.SECONDS.sleep(i1);
            String str = "我是线程：" + Thread.currentThread().getName() + " 我休息了" + i1;
            return str;
        }
    }


    public static void main(String[] args) {

        //开启多线程
        ExecutorService exs = Executors.newFixedThreadPool(10);

        List<Future> futureList = new ArrayList<Future>();
        for (int i = 0; i < 5; i++) {
            futureList.add(exs.submit(new CallabelTask()));
        }
        for (Future future : futureList) {
            try {
                System.out.println(future.get().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
