package org.tosware.zad4;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {

    private final Chopstick chopstick1, chopstick2;
    int hungerPoints;
    private static Semaphore janitor = new Semaphore(4);

    public Philosopher(final String name, final Chopstick chopstick1, final Chopstick chopstick2) {
        super(name);
        this.chopstick1 = chopstick1;
        this.chopstick2 = chopstick2;
        hungerPoints = 10000;
    }

    @Override
    public void run() {
        try {
            janitor.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(hungerPoints > 0) {
            chopstick1.get();
            chopstick2.get();
            System.out.println(getName() + "eats. Yum!");
            hungerPoints--;
            chopstick1.release();
            chopstick2.release();
        }
        janitor.release();
    }
}