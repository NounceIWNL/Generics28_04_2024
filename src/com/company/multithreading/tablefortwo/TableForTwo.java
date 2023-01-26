package com.company.multithreading.tablefortwo;

import java.util.concurrent.Semaphore;

public class TableForTwo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 6; i++) {
            new Client(semaphore, i).start();
        }

    }
}

class Client extends Thread {

    Semaphore semaphore; //Показывает количество свободных мест
    int count = 3; //Количество блюд
    int id; //ID клиента

    public Client(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    public void run() {
        try {
            int index = 1;
            while (index <= count) {
                semaphore.acquire(); //Запросить место
                System.out.println("Клиент " + id + " садится за стол и ест блюдо " + index);
                sleep(200); //Ест
                index++;
                System.out.println("Клиент " + id + " выходит из-за стола");
                semaphore.release();
                sleep(200); //Гуляет
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
