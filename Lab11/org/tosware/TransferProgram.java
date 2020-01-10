package org.tosware;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class TransferProgram extends Thread {

    private final Account[] accounts;
    // private static Semaphore janitor = new Semaphore(Bank.AccountsNumber - 1);

    public TransferProgram(final String name, final Account[] accounts) {
        super(name);
        this.accounts = accounts;
    }

    @Override
    public void run() {
        int transfers = Bank.InitialTransferNumber;
        int rnd1, rnd2;
        Random r = new Random();
        // try {
        //     janitor.acquire();
        // } catch (InterruptedException e1) {
        //     // TODO Auto-generated catch block
        //     e1.printStackTrace();
        // }
        while (transfers-- != 0) {
            rnd1 = r.nextInt(accounts.length);
            do {
                rnd2 = r.nextInt(accounts.length);
            } while (rnd1 == rnd2);

            Account acc1 = accounts[rnd1];
            Account acc2 = accounts[rnd2];

            System.out.println(getName());
            synchronized(acc1) {
                acc1.setMoney(acc1.getMoney()-1);
            }
            synchronized(acc2) {
                acc2.setMoney(acc2.getMoney()+1);
            }
        }
        // janitor.release();
    }
}
