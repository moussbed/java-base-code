package org.mb.base.threads;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaitingForAllTasksToFinish {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        try {

            executorService.execute(()-> {
                for (int i = 0; i < 50; i++) {
                    System.out.println(i+ " First");
                }
            });

            executorService.execute(()-> System.out.println("Monday"));
            executorService.execute(()-> {
                for (int i = 0; i < 50; i++) {
                    System.out.println(RandomStringUtils.random(i,true,true));
                }
            });
            executorService.execute(()-> System.out.println("Sartuday"));



        }finally {
             executorService.shutdown();
        }

        try {
            executorService.awaitTermination(2, TimeUnit.MILLISECONDS);

            if(executorService.isTerminated()) System.out.println("All tasks finished");
            else System.out.println("At least one task is still running");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
