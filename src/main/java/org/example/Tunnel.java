package org.example;

import java.util.concurrent.Semaphore;

public class Tunnel {
    private final int QUEUE_CAPACITY = 2;
    private final int length = 20;
    private final Semaphore semaphore = new Semaphore(QUEUE_CAPACITY);

    private static final class Holder {
        private static final Tunnel INSTANCE = new Tunnel();
    }

    public static Tunnel getInstance() {
        return Holder.INSTANCE;
    }

    private Tunnel() {}

    public void add(Ship ship, boolean isBack) {
        try {
            semaphore.acquire();
            if (isBack) {
                System.out.printf("%s корабль отплывает от причала и вошел в туннель%n",
                        Thread.currentThread().getName());
                Thread.sleep(length / ship.getSpeed() * 1000);
                System.out.printf("%s корабль отплывает от причала и вышел из туннеля%n",
                        Thread.currentThread().getName());
            } else {
                System.out.printf("%s корабль вошел в туннель%n",
                        Thread.currentThread().getName());
                Thread.sleep(length / ship.getSpeed() * 1000);
                System.out.printf("%s корабль вышел из туннеля%n",
                        Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        semaphore.release();
    }

}
