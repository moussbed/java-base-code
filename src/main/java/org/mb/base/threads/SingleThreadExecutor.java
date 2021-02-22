package org.mb.base.threads;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 Let’s start with a simple example using the newSingleThreadExecutor() method to obtain
 an ExecutorService instance and the execute() method to perform asynchronous tasks:
 */
public class SingleThreadExecutor {

    public static void main(String[] args) {


        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService executorService = null;

        try {

            executorService = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            executorService.execute(() -> System.out.println("Printing zoo inventory"));
            executorService.execute(() -> {
                for(int i=0; i<3; i++)
                    System.out.println("Printing record: "+i);
            });
            executorService.execute(() -> System.out.println("Printing zoo inventory"));
            System.out.println("end");
        }finally {
            if(executorService != null) executorService.shutdown();
        }

        // Resultat
        /*
          begin
          Printing zoo inventory
          Printing record: 0
          Printing record: 1
          end
          Printing record: 2
          Printing zoo inventory

        */

        // Notice

        /*
         With a single-thread executor, results are guaranteed to be executed in the order in which they are added to the executor service.
         Notice that the end text is output while our thread executor tasks are still running.
         This is because the main() method is still an independent thread from the ExecutorService,
         and it can perform tasks while the other thread is running.

        */


    }
}
