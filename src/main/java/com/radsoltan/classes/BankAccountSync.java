package com.radsoltan.classes;

import com.radsoltan.exc.BankAccountActionInvalidException;

public class BankAccountSync {
    private volatile int balance = 0;
    private volatile boolean isOpen = false;

    public synchronized void open() {
        isOpen = true;
    }

    public int getBalance() throws BankAccountActionInvalidException {
        if (!isOpen)
            throw new BankAccountActionInvalidException("Account closed");
        return balance;
    }

    public synchronized void deposit(int i) throws BankAccountActionInvalidException {
        if (!isOpen)
            throw new BankAccountActionInvalidException("Account closed");
        if (i < 0)
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        balance += i;
    }

    public synchronized void withdraw(int i) throws BankAccountActionInvalidException {
        if (!isOpen)
            throw new BankAccountActionInvalidException("Account closed");
        if (i < 0)
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        if (balance == 0)
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        if (balance < i)
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        balance -= i;
    }

    public synchronized void close() {
        isOpen = false;
        balance = 0;
    }
}
