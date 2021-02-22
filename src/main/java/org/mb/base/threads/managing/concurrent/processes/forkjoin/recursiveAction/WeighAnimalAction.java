package org.mb.base.threads.managing.concurrent.processes.forkjoin.recursiveAction;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Stream;

public class WeighAnimalAction extends RecursiveAction {

    private int start;
    private int end ;
    private Double[] weights;

    public WeighAnimalAction(int start, int end, Double[] weights) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    @Override
    protected void compute() {

        if((end-start)<=3){

            for (int i = start; i < end; i++) {
                weights[i] = (double) new Random().nextInt(100);
                System.out.println("Animal Weighed: "+i);
            }
        }
        else{
            int middle = start + ((end - start) / 2);
            System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
            invokeAll(new WeighAnimalAction(start,middle, weights), new WeighAnimalAction(middle,end, weights));
        }

    }

    public static void main(String[] args) {
        Double[] weights = new Double[10];

        ForkJoinTask<?> tasks = new WeighAnimalAction(0, weights.length, weights);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(tasks);

        // Print results
        System.out.println();
        System.out.print("Weights: ");

        Stream.of(weights).forEach(d-> System.out.print(d.intValue() + " "));

    }
}
