package org.tosware;

public class B extends Thread {
    private int i;
    private Printer p;

    public B(Printer p, int i) {
        this.i = i;
        this.p = p;
	}

	@Override
    public void run() {
        p.printB();
        try {
            sleep(i * 1000);
        } catch (InterruptedException e) { }
    }
}
