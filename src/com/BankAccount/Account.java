package com.BankAccount;

public class Account {
    private static int nrOfAccounts = 0;
    protected double balance;
    protected String name;

    public Account() {
        this.balance = 0;
        this.nrOfAccounts++;
    }

    public Account(double balance) {
        this.balance = balance;
        this.nrOfAccounts++;
    }

    public Account( String name,double balance) {
        this.balance = balance;
        this.name = name;
    }

    protected static int getNrOfAccount() {
        return nrOfAccounts;
    }

    protected void deposit(double balance) {
        this.balance += balance;
    }

    protected double getBalance() {
        return balance;
    }

    protected void withdraw(double balance) {
        if (this.balance >= balance && this.balance > 0) {
            this.balance -= balance;
        }
    }

    protected String getName() {
        return name;
    }

    protected void transferTo(Account accountFrom,Account accountTo, double amount) {
        if (amount < accountFrom.getBalance()) {
            accountTo.deposit(amount);
        }
    }

    protected void setName(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{\n" +
                "balance=" + balance +
                ", name='" + name + '\'' +
                '}';
    }
}

