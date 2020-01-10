package org.tosware;

public class Bank {
    public static final int AccountsNumber = 100;
    public static final int TransferProgramsNumber = 10;
    public static final int InitialAccountMoney = 100;
    public static final int InitialTransferNumber = 10000;

    public void Start() {
        Account[] accounts = new Account[AccountsNumber];
        TransferProgram[] transferPrograms = new TransferProgram[TransferProgramsNumber];
        for (int i = 0; i < AccountsNumber; i++)
            accounts[i] = new Account("Account " + i);

        System.out.println("Initial sum of money: " + getSumOfMoney(accounts));

        for (int i = 0; i < TransferProgramsNumber; i++) {
            transferPrograms[i] = new TransferProgram("TP " + i, accounts);
            transferPrograms[i].start();
        }

        for (int i = 0; i < TransferProgramsNumber; i++)
            try {
                transferPrograms[i].join();
            } catch (InterruptedException e) {
                // ignored
            }

        System.out.println("Sum of money after transfers: " + getSumOfMoney(accounts));
    }
    private static int getSumOfMoney(Account[] accounts) {
        int sum = 0;
        for(int i = 0; i < accounts.length; ++i) {
            sum += accounts[i].getMoney();
        }
        return sum;
    }
}