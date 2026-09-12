package com.sushant.properties.encapsulation;

public class BankAccount {

    private final String accountNumber;
    private double balance;

    BankAccount(String accountNumber){
        this.accountNumber=accountNumber;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
