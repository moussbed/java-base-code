package org.mb.base.threads;

public class Polling {

    private static int counter=0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            for (int i = 0; i < 500; i++) {
               // System.out.println(counter);
                 counter++;
            }
        }).start();

        while (counter<100) {
            System.out.println("Not reached yet");
           // Thread.sleep(1000);
        }

        System.out.println("Reached !");
    }
}
