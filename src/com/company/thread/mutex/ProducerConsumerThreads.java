package com.company.thread.mutex;

import java.util.LinkedList;

public class ProducerConsumerThreads {
    // Java program to implement solution of producer-consumer problem.
    public static void main(String[] args) throws InterruptedException {
        // Object of a class that has both produce() and consume() methods
        final ProducerConsumer pc = new ProducerConsumer();

        // Create producer thread
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create consumer thread
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        producer.start();
        consumer.start();

        // t1 finishes before t2
        producer.join();
        consumer.join();
    }

    // This class has a list, producer (adds items to list
    // and consumer (removes items).
    public static class ProducerConsumer {

        // Create a list shared by producer and consumer
        // Size of list is 2.
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 10;

        // Function called by producer thread
        public void produce() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (this) {
                    // producer thread waits while list is full
                    while (list.size() == capacity) wait();
                    System.out.println("Producer produced-" + value);

                    // to insert the jobs in the list
                    list.add(value++);

                    // notifies the consumer thread that now it can start consuming
                    notify();

                    // makes the working of program easier to understand
                    Thread.sleep(1000);
                }
            }
        }

        // Function called by consumer thread
        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    // consumer thread waits while list
                    // is empty
                    while (list.size() == 0) wait();

                    // to retrieve the ifrst job in the list
                    int val = list.removeFirst();

                    System.out.println("Consumer consumed-" + val);

                    // Wake up producer thread
                    notify();

                    // and sleep
                    Thread.sleep(1000);
                }
            }
        }
    }
}
