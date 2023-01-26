package com.company.multithreading.sleepingbarber;

/*
Спящий брадобрей.
Рассмотрим парикмахерскую, в которой работает один парикмахер, имеется одно кресло для стрижки
и несколько кресел в приемной для посетителей, ожидающих своей очереди. Если в парикмахерской нет посетителей,
парикмахер засыпает прямо на своем рабочем месте. Появившийся посетитель должен его разбудить,
в результате чего парикмахер приступает к работе. Если в процессе стрижки появляются новые посетители,
они должны либо подождать своей очереди, либо покинуть парикмахерскую, если в приемной
нет свободного кресла для ожидания (т.е. это стратегия обслуживания с отказами).
 */

import com.company.databases.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class SleepingBarber {

    final static int limitCustomers = 3; //Лимит посетителей
    static final AtomicInteger idCustomer = new AtomicInteger(); //Маркировка каждого потока
    static final AtomicBoolean isFree = new AtomicBoolean(); //Если парикмахер свободен

    public static void main(String[] args) {

        new Thread(new BarberShop()).start();

    }

    public static void waiting() {
        try {
            Thread.sleep(((int) (Math.random() * 100)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class BarberShop implements Runnable {
        final static List<Thread> customers = new ArrayList<>();
        final static Semaphore semaphore = new Semaphore(limitCustomers);
        final static ReentrantLock reentrantLock = new ReentrantLock(); //Занятость парикмахера
        static final AtomicInteger numCustomers = new AtomicInteger(); //Текущее количество посетителей
        static final SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        static final Object object = new Object();

        public BarberShop() {
            numCustomers.set(0);
        }

        @Override
        public void run() {
            isFree.set(true);
            new Thread(new Barber()).start();
            //Generate customers
            while (true) {
                new Thread(new Customer()).start();
                waiting();
            }
        }

        //Сгенерировать клиента
        public void generate() {
            new Thread(new Customer()).start();
            waiting();
        }

        static class Barber implements Runnable {

            public void cutHair() {
                int id = 0;
                try {
                    id = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Barber is cutting hair of " + id);
                waiting();
            }

            public void sleep() {
                System.out.println("Barber is sleeping");
                waiting();
            }

            @Override
            public void run() {
                while (true) {
                    if (numCustomers.get() > 0) {
                        isFree.set(false);
                        cutHair();
                        isFree.set(true);
                    } else
                        sleep();
                }
            }
        }

        static class Customer implements Runnable {
            int id = idCustomer.getAndIncrement();

            public void enter() {
                System.out.printf("Customer %d enters%n", id);
                waiting();
                waiting();
                waiting();
            }

            public void startCut() {
                System.out.printf("Customer %d get haircut%n", id);
                waiting();
            }

            public void leave() {
                System.out.printf("Customer %d leaves%n", id);
                waiting();
            }

            @Override
            public void run() {
                try {
                    enter();
                    if (numCustomers.get() < limitCustomers) {
                        semaphore.acquire(); //Запросить место
                        numCustomers.getAndIncrement();
                        while (!isFree.get()) //Ждать парикмахера
                            waiting();

                        //Стричься
                        reentrantLock.lock();
                        queue.put(id);
                        startCut();
                        reentrantLock.unlock();

                        semaphore.release(); //Освободить место
                        numCustomers.getAndDecrement();
                    }
                    leave();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}