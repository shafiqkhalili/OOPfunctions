package com.BankAccount;

public class Account {
    private double balance;
    private static int nrOfAccounts = 0;
    private String name;

    public Account() {
        this.balance = 0;
        this.nrOfAccounts++;
    }

    public Account(double balance) {
        this.balance = balance;
        this.nrOfAccounts++;
    }

    public Account(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public void deposit(double balance) {
        this.balance += balance;
    }

    public double getBalance() {
        return balance;
    }

    public static int getNrOfAccount() {
        return nrOfAccounts;
    }

    public double withdraw(double balance) {
        if (this.balance >= balance && balance > 0) {
            this.balance -= balance;
            return balance;
        }
        double withdrawBalance = this.balance;
        this.balance = 0;
        return withdrawBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name='" + name + '\'' + " \nBalance: " + getBalance();
    }
}

