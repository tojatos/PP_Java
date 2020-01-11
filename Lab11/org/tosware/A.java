package org.tosware;

public class A extends Thread {
    private int[] arr;
    private Printer p;

    public A(Printer p, int[] arr) {
        this.arr = arr;
        this.p = p;
    }

    @Override
    public void run() {
        for(int i = 0; i < arr.length; ++i) {
            p.printA();
            try {
                sleep(arr[i] * 1000);
            } catch (InterruptedException e) { }
        }
    }
}
