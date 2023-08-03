package com.radsoltan.classes;

import com.radsoltan.exc.BankAccountActionInvalidException;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {
    private final AtomicInteger balance = new AtomicInteger(0);
    private final AtomicBoolean isOpen = new AtomicBoolean(false);

    public void open() {
        isOpen.compareAndSet(false,true);
    }

    public int getBalance() throws BankAccountActionInvalidException {
        if (!isOpen.get())
            throw new BankAccountActionInvalidException("Account closed");
        return balance.get();
    }

    public void deposit(int i) throws BankAccountActionInvalidException {
        if (!isOpen.get())
            throw new BankAccountActionInvalidException("Account closed");
        if (i < 0)
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        balance.addAndGet(i);
    }

    public void withdraw(int i) throws BankAccountActionInvalidException {
        if (!isOpen.get())
            throw new BankAccountActionInvalidException("Account closed");
        if (i < 0)
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        if (balance.get() == 0)
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        if (balance.get() < i)
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        balance.addAndGet(-i);
    }

    public void close() {
        isOpen.set(false);
        balance.set(0);
    }
}
