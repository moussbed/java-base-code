package org.mb.base.threads;

import java.util.concurrent.*;

public class BlockingQueues {

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        try {
            blockingQueue.offer(40);
            blockingQueue.offer(10,4, TimeUnit.SECONDS);

            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll(3, TimeUnit.MILLISECONDS));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();

        try {
            blockingDeque.offer(91);
            blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES);
            blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS);
            blockingDeque.offer(3, 4, TimeUnit.SECONDS);

            System.out.println(blockingDeque.poll());
            System.out.println(blockingDeque.poll(950, TimeUnit.MILLISECONDS));
            System.out.println(blockingDeque.pollFirst(200, TimeUnit.NANOSECONDS));
            System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
