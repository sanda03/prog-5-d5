package org.example;

public class Money {
    private double balance;
    private boolean locked;

    public Money(double initialBalance) {
        this.balance = initialBalance;
        this.locked = false;
    }

    public boolean withdraw(double amount) {
        if (locked || balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public void deposit(double amount) {
        if (!locked) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return locked;
    }

    public void lock() {
        this.locked = true;
    }

    public void unlock() {
        this.locked = false;
    }
}
