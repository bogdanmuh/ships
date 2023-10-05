package org.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Tunnel {
    private static BlockingQueue<Ship> queue;
    private final int QUEUE_CAPACITY = 5;
    public Tunnel() {
        if (queue == null) {
            queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY, true);
        }
    }
    public void add(Ship ship) {
        queue.add(ship);
    }
    public Ship poll() {
        Ship ship = queue.poll();
        return ship;
    }

    public boolean isfull() {
       return queue.size() == QUEUE_CAPACITY;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

}
