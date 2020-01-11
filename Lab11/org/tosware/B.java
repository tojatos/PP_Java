package org.tosware;

public class B extends Thread {
    private int[] arr;
    private Printer p;

    public B(Printer p, int[] arr) {
        this.arr = arr;
        this.p = p;
    }

	@Override
    public void run() {
        for(int i = 0; i < arr.length; ++i) {
            p.printB();
            try {
                sleep(arr[i] * 1000);
            } catch (InterruptedException e) { }
        }
    }
}
