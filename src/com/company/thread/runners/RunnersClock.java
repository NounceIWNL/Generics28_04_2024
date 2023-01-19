package com.company.thread.runners;

public class RunnersClock {
    public static void main(String[] args) {
        Runner runner1 = new Runner("1");
        Runner runner2 = new Runner("2");

        Thread thread1 = new Thread(runner1);
        thread1.setPriority(1);
        thread1.start();

        Thread thread2 = new Thread(runner2);
        thread2.setPriority(10);
        thread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        runner1.flag = true;
        runner2.flag = true;

        thread1.interrupt();
        thread2.interrupt();
    }
}

class Runner implements Runnable {

    String name;
    boolean flag = false;

    public Runner(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        int i = 1;

        while (!Thread.currentThread().isInterrupted()) {
            System.out.printf("Runner %s running %d%n", name, i++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
