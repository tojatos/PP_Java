package org.tosware;

public class A extends Thread {
    private int i;
    private Printer p;

    public A(Printer p, int i) {
        this.i = i;
        this.p = p;
    }

    @Override
    public void run() {
        p.printA();
        try {
            sleep(i * 1000);
        } catch (InterruptedException e) {
        }
    }
}
