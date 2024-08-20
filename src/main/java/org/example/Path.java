package org.example;

public class Path {
    Tunnel tunnel = Tunnel.getInstance();
    private final PierLoader pierLoader = new PierLoader();

    public void begin (Ship ship) {
        tunnel.add(ship,false);
        pierLoader.add(ship);
        tunnel.add(ship, true);
    }

}
