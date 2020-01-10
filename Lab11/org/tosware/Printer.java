package org.tosware;

public class Printer {
    public synchronized void printA() {
        while (!Main.canAPrint()) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
            System.out.println("A");
        }
    }

    public synchronized void printB() {
        System.out.println("B");
        notifyAll();
    }

}
