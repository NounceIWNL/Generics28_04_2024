package com.company.thread.future_callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.stream.Stream;

public class FutureCallable {
    public static void main(String[] args) {
        Callable<String> callable = () -> {
            Integer sum = Stream.iterate(0, i -> i + 1)
                    .limit(10)
                    .map(i -> {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return i;
                    })
                    .reduce(0, Integer::sum);
            return Thread.currentThread().getName() + " is finished; sum = " + Integer.toString(sum);

        };

        FutureTask<String> future = new FutureTask<>(callable);

        new Thread(future).start();

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
