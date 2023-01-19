package com.company.thread.runwait;

public class RunnersFlag {
    public static void main(String[] args) {
        Runner runner1 = new Runner("1");
        ;

        Thread thread1 = new Thread(runner1);
        thread1.setPriority(1);
        thread1.start();

        System.out.println("run");

        runner1.stopProcess();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        runner1.resumeProcess();

        //thread1.interrupt();
    }
}

class Runner implements Runnable {

    String name;
    boolean flag = false;
    // Object mutex = new Object();

    public Runner(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        int i = 1;

        while (!Thread.currentThread().isInterrupted()) {
            System.out.printf("Runner %s running %d%n", name, i++);
            waitProcess();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                return;
            }
        }
    }

    public void waitProcess() {
        synchronized (this) {
            if (flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void resumeProcess() {
        synchronized (this) {
            if (flag) {
                this.notifyAll();
                flag = false;
            }
        }
    }

    public void stopProcess() {
        flag = true;
    }

    public void startProcess() {
        flag = false;
    }
}
