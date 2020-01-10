package org.tosware;

import java.util.concurrent.Semaphore;

public class Account {
    public Semaphore s = new Semaphore(1);
    private Integer money = Bank.InitialAccountMoney;
    private final String name;

    public Account(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
