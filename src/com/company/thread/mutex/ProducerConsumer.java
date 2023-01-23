package com.company.thread.mutex;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ProducerConsumer {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        new Producer("producer", buffer);
        new Consumer("consumer", buffer);
    }

    static class Producer implements Runnable {
        private Thread thread;
        private static Random random = new Random();
        private Buffer buffer;

        public Producer(String name, Buffer buffer) {
            this.buffer = buffer;
            thread = new Thread(this);
            thread.setName(name);
            thread.start();
        }

        public void run() {
            while (true) {
                try {
                    Thread.sleep(random.nextInt(1) * 100 + 100);
                } catch (InterruptedException e) {
                }
                buffer.put("1");
                System.out.println("Put: " + Thread.currentThread().getName() + ", buffer: " + buffer.list.size());
            }
        }
    }

    static class Consumer implements Runnable {
        private Thread thread;
        private Buffer buffer;
        Random random = new Random();

        public Consumer(String name, Buffer buffer) {
            this.buffer = buffer;
            thread = new Thread(this);
            thread.setName(name);
            thread.start();
        }

        public void run() {
            while (true) {
                String data = buffer.get();
                System.out.println("Get: " + Thread.currentThread().getName() + ", buffer: " + buffer.list.size());
                try {
                    Thread.sleep(random.nextInt(1) * 1000 + 1000);
                } catch (InterruptedException e) {
                }

            }
        }
    }

    static class Buffer {
        public static int maxSize = 10;
        private List<String> list = new LinkedList<>();

        public synchronized void put(String s) {
            while (list.size() == maxSize) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(s);
            notify();
        }

        public synchronized String get() {
            while (list.size() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String s = list.remove(0);
            notify();
            return s;
        }
    }
}
