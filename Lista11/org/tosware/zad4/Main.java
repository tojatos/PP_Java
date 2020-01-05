package org.tosware.zad4;

public class Main {
    public static void main(String[] args) {
	   final int P = 5;
       Philosopher[] philosophers = new Philosopher[P];
       Chopstick[] chopsticks = new Chopstick[P];
       for (int i=0; i<P; i++) {
           chopsticks[i] = new Chopstick("Chopstick " + i);
       }

       for (int i=0; i<P; i++) {
    	   philosophers[i] = new Philosopher("Philosopher " + i, chopsticks[i], chopsticks[(i+1)%P]); philosophers[i].start();}
    }
}