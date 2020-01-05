package org.tosware;

import java.util.concurrent.Semaphore;

class IntCell {
	private int n = 0;

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
}

class Count extends Thread {
	private static IntCell n = new IntCell();

	@Override
	public void run() {
		int temp;
		for (int i = 0; i < 200000; i++) {
			temp = n.getN();
			n.setN(temp + 1);
			System.out.println("The value of n is " + n.getN());
			/**
			 * Variables sometimes can be set based on invalid temp value
			 */
		}
	}
}

class MonitorCount extends Thread {
	private static IntCell n = new IntCell();

	@Override
	public void run() {
		int temp;
		for (int i = 0; i < 200000; i++) {
			synchronized (n) {
				temp = n.getN();
				// if(temp != n.getN()) System.out.println("Oops! " + temp + " " + n.getN());
				n.setN(temp + 1);
				System.out.println("The value of n is " + n.getN());
			}
		}
	}
}

class SemaforCount extends Thread {
	private static IntCell n = new IntCell();
	private static Semaphore sem = new Semaphore(1);

	@Override
	public void run() {
		int temp;
		for (int i = 0; i < 200000; i++) {
			try {
				sem.acquire();
			} catch (InterruptedException e) {
				//TODO: ignored
			}
			temp = n.getN();
			// if(temp != n.getN()) System.out.println("Oops! " + temp + " " + n.getN());
			n.setN(temp + 1);
			System.out.println("The value of n is " + n.getN());
			sem.release();
		}
	}
}

public class Main {
	public static void main(String[] args) {
		zad2b();
	}

	public static void zad1() {
		Count p = new Count();
		Count q = new Count();
		p.start();
		q.start();
		try {p.join(); q.join();}
		catch (InterruptedException e) {}
	}

	public static void zad2a() {
		MonitorCount p = new MonitorCount();
		MonitorCount q = new MonitorCount();
		p.start();
		q.start();
		try {p.join(); q.join();}
		catch (InterruptedException e) {}
	}

	public static void zad2b() {
		SemaforCount p = new SemaforCount();
		SemaforCount q = new SemaforCount();
		p.start();
		q.start();
		try {p.join(); q.join();}
		catch (InterruptedException e) {}
	}
}

/**
 * zad3
 * 
 * It is NOT safe to change notifyAll() with notify(), because there are threads that serve different purposes,
 * so we may wake up producer after producing something, that producer checks the loop and waits (everything is filled), and all threads are waiting there.
 * 
 * See more: https://stackoverflow.com/a/3186336/7136056
 */
