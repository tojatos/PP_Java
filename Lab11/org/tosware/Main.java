package org.tosware;

public class Main {
    public static void main(String[] args) {
        zad3();
    }

    private static void zad1() {
        Bank bank = new Bank();
        bank.Start();
    }

    private static void zad3() {
        final int[] test1a = new int[] { 1, 1, 1 };
        final int[] test1b = new int[] { 1, 1, 1 };
        final int[] test2a = new int[] { 1, 2, 3 };
        final int[] test2b = new int[] { 3, 2, 1 };
        final int[] test3a = new int[] { 1, 2, 1, 1 };
        final int[] test3b = new int[] { 1, 1, 1 };
        System.out.println("test 1: ");
        testPrinters(test1a, test1b);
        System.out.println("test 2: ");
        testPrinters(test2a, test2b);
        System.out.println("test 3: ");
        testPrinters(test3a, test3b);

    }

    private static void testPrinters(int[] a, int[] b) {
        final int aCount = 10;
        final int bCount = 10;
        A[] as = new A[aCount];
        B[] bs = new B[bCount];
        Printer p = new Printer();
        for (int i = 0; i < aCount; i++) {
            as[i] = new A(p, a);
            as[i].start();
        }
        for (int i = 0; i < bCount; i++) {
            bs[i] = new B(p, b);
            bs[i].start();
        }

        for (int i = 0; i < aCount; i++) {
            try { as[i].join(); } catch (InterruptedException e) { }
        }
        for (int i = 0; i < bCount; i++) {
            try { bs[i].join(); } catch (InterruptedException e) { }
        }
        System.out.println();

    }
}