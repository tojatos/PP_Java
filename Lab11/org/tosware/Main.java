package org.tosware;

public class Main {
    public static int alla = 0;
    public static int allb = 0;
    public static boolean canAPrint() {
        return alla < allb;
    }
    public static void main(String[] args) {
        zad3();
    }
    private static void zad1() {
        Bank bank = new Bank();
        bank.Start();
    }
    private static void zad3() {
        final int aCount = 10;
        final int bCount = 10;
        A[] as = new A[aCount];
        B[] bs = new B[bCount];
        Printer p = new Printer();
        for (int i = 0; i < aCount; i++)
        {
            as[i] = new A(p, 1+i);
            as[i].start();
        }
        for (int i = 0; i < bCount; i++)
        {
            bs[i] = new B(p, 1+i);
            bs[i].start();
        }
    }
}