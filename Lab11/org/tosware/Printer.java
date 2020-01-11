package org.tosware;

public class Printer {
    public static int alla = 0;
    public static int allb = 0;
    public static boolean canAPrint() {
        return alla < allb;
    }
    public synchronized void printA() {
        while (!canAPrint()) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        System.out.print("A");
        alla++;
    }

    public synchronized void printB() {
        System.out.print("B");
        allb++;
        notifyAll();
    }

}
