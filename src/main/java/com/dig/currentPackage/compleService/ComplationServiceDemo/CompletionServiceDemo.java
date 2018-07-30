package com.dig.currentPackage.compleService.ComplationServiceDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CompletionServiceDemo {


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
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(exs);
        List<Future> futureList = new ArrayList<Future>();
        for (int i = 0; i < 5; i++) {
            completionService.submit(new CallabelTask());
        }

        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
