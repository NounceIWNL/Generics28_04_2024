package com.company.thread.basic;

public class ThreadDemo extends Thread {
    public static void main(String[] args) {
        System.out.println("Start : " + Thread.currentThread().getName());

        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();

        System.out.println("Finish : " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("Start :" + Thread.currentThread().getName());
        System.out.println("Finish : " + Thread.currentThread().getName());
    }
}
