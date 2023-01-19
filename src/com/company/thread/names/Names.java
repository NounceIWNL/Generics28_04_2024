package com.company.thread.names;

public class Names {
    public static String message;
    public static long count = 0;
    public static Object object = new Object();

    public static void main(String[] args) {
        YoungMan youngMan = new YoungMan();
        youngMan.start();
        OldMan oldMan = new OldMan();
        oldMan.start();
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class YoungMan extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Names.object) { //Сначала убрать синхронизацию и посмотреть эффект
                Names.message = Long.toString(Names.count++) + " Young: ";
                Names.sleep(50);
                Names.message += "10 years old";
                Names.sleep(50);
                System.out.println(Names.message);
            }
            Names.sleep(50);
        }
    }
}

class OldMan extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Names.object) {
                Names.message = Long.toString(Names.count++) + " Old:   ";
                Names.sleep(70);
                Names.message += "50 years old";
                Names.sleep(50);
                System.out.println(Names.message);
            }
            Names.sleep(70);
        }
    }
}
