package com.BankAccount;

public class SavingAccount extends Account {
    private double interestRate;

    protected SavingAccount(String name, double balance, double interestRate) {
        super(name,balance);
        this.interestRate = interestRate;

    }

    protected void addInterest() {
        this.balance += this.balance * (this.interestRate / 365);
    }



    @Override
    public String toString() {
        return "SavingAccount\n{" +
                "balance=" + balance +
                ", interestRate=" + interestRate +
                '}';
    }
}
