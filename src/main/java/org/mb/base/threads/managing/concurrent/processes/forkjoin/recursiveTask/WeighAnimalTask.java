package org.mb.base.threads.managing.concurrent.processes.forkjoin.recursiveTask;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class WeighAnimalTask extends RecursiveTask<Double> {

    private int start;
    private int end ;
    private Double[] weights;

    public WeighAnimalTask(int start, int end, Double[] weights) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    @Override
    protected Double compute() {

        if(end-start <= 3) {
            double sum = 0;
            for(int i=start; i<end; i++) {
                weights[i] = (double)new Random().nextInt(100);
                System.out.println("Animal Weighed: "+i);
                System.out.println(weights[i]);
                sum += weights[i];
            }
            return sum;
        }else {
            int middle = start+((end-start)/2);
            System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
            RecursiveTask<Double> otherTask = new WeighAnimalTask(start,middle,weights);
            otherTask.fork();
            return new WeighAnimalTask(middle,end,weights).compute() + otherTask.join();
        }
    }

    public static void main(String[] args) {
        Double[] weights = new Double[10];
        ForkJoinTask<Double> tasks = new WeighAnimalTask(0, weights.length, weights);
        ForkJoinPool pool = new ForkJoinPool();
        Double sum = pool.invoke(tasks);
        System.out.println(sum);


    }
}
