package org.personal.rampup.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class SumOfArrays {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        processSequential(array1, array2);
        processParallel(array1, array2);

    }

    private static void processSequential(int[] array1, int[] array2) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future> futureList = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            Future future = executorService.submit(new ArrayWorker(array1[i], array2[i]));
            futureList.add(future);
        }

        int[] resultArray = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            resultArray[i] = (Integer) futureList.get(i).get();
        }


        Arrays.stream(resultArray)
                .forEach(System.out::print);
        System.out.println("\n Time taken for sequential execution : " + (System.currentTimeMillis() - startTime) + " ms");
        executorService.shutdown();
    }


    public static void processParallel(int[] array1, int[] array2) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println();
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<ArrayWorker> taskList = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            taskList.add(new ArrayWorker(array1[i], array2[i]));
        }
        List<Future<Integer>> futureList = executorService.invokeAll(taskList);
        int[] resultArray = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            resultArray[i] = (Integer) futureList.get(i).get();
        }
        Arrays.stream(resultArray)
                .forEach(System.out::print);
        System.out.println("\n Time taken for parallel execution : " + (System.currentTimeMillis() - startTime) + " ms");
        executorService.shutdown();
    }


}

class ArrayWorker implements Callable<Integer> {
    int e1;
    int e2;

    public ArrayWorker(int e1, int e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public Integer call() throws Exception {
        return e1 + e2;
    }
}
