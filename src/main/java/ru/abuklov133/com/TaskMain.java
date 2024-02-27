package ru.abuklov133.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskMain {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 1_000_000; i++) {
                    if (i % 2 == 0) {
                        sum += i;
                    }
                }
                System.out.println("Task1 = " + sum);
                countDownLatch.countDown();
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                long sum = 0;
                for (int i = 0; i < 1_000_000; i++) {
                    if (i % 7 == 0) {
                        sum += i;
                    }
                }
                System.out.println("Task2 = " + sum);
                countDownLatch.countDown();
            }
        };

        Runnable task3 = new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                int sum = 0;
                List<Integer> integers = new ArrayList<>();
                for (int i = 0; i < 1000; i++) {
                    integers.add(random.nextInt(1000));
                    if (integers.get(i) % 2 == 0) {
                        sum += integers.get(i);
                    }
                }
                System.out.println("Task3 = " + sum);
                countDownLatch.countDown();
            }
        };
        long before = System.currentTimeMillis();
        executorService.execute(task2);
        executorService.execute(task3);
        executorService.execute(task1);
        executorService.shutdown();
        countDownLatch.await();
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }
}
