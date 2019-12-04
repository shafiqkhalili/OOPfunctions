package com.BankAccount;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        //ArrayList<SavingAccount> savingAccounts = new ArrayList<>();
        int input = 0;
        Account acc = new Account("test1",1000);
        accounts.add(acc);
        SavingAccount acc1 = new SavingAccount("Saving2",200,2.0);
        accounts.add(acc1);
        while (input != 7) {
            System.out.println("Select an option: ");
            System.out.println("1. To create new account");
            System.out.println("2. To list existing accounts");
            System.out.println("3. To deposit into existing account");
            System.out.println("4. To withdraw from existing account");
            System.out.println("5. To create savings");
            System.out.println("6. To transfer money from saving account");
            System.out.println("7. To exit");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    Account ac = createNewAccount();
                    accounts.add(ac);
                    break;
                case 2:
                    if (accounts.size() > 0) {
                        printAccounts(accounts);
                        //printSavingAccounts(savingAccounts);
                    } else {
                        System.out.println("Create account first!");
                    }
                    break;
                case 3:
                    if (accounts.size() > 0) {
                        deposit(accounts);
                    } else {
                        System.out.println("Create account first!");
                    }
                    break;
                case 4:
                    if (accounts.size() > 0) {
                        withdraw(accounts);
                    } else {
                        System.out.println("Create account first!");
                    }
                    break;
                case 5:
                    SavingAccount sac = createSavingAccount();
                    accounts.add(sac);
                    break;
                case 6:
                    transferToSaving(accounts);
                    break;
            }
        }
    }

    private static Account createNewAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type name of new account:");
        String name = sc.nextLine();
        System.out.println("How much would you like to save in new account?");
        double balance = sc.nextInt();
        return new Account( name,balance);

    }

    private static void deposit(ArrayList<Account> accounts) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select index of an account to deposit");
        printAccounts(accounts);
        int index = sc.nextInt();
        System.out.println("How much you want to deposit?");
        int amount = (int) sc.nextDouble();
        depositTo(accounts.get(index), amount);
    }

    private static void depositTo(Account account, double depositAmount) {
        account.deposit(depositAmount);
        System.out.println("Deposited successfully!");
    }

    private static void withdraw(ArrayList<Account> accounts) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select index of an account to withdraw from");
        printAccounts(accounts);
        int index = sc.nextInt();
        System.out.println("How much you want to withdraw?");
        int amount = (int) sc.nextDouble();
        withdrawFrom(accounts.get(index), amount);
    }

    private static void withdrawFrom(Account account, double withdrawAmount) {

        if (account.getBalance() > withdrawAmount) {
            account.withdraw(withdrawAmount);
            System.out.println("Withdrawn successfully!");
        } else {
            System.out.println("Not enough balance, you can only withdraw " + account.getBalance());
        }
    }

    private static void printAccounts(ArrayList<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println("index: " + i + " {" + accounts.get(i) + "}");
        }
    }
    private static void printSavingAccounts(ArrayList<SavingAccount> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println("index: " + i + " {" + accounts.get(i) + "}");
        }
    }

    private static SavingAccount createSavingAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type name of new Saving account:");
        String name = sc.nextLine();
        System.out.println("How much would you like to save?");
        int balance = sc.nextInt();
        System.out.println("What is the interest rate?");
        double interestRate = sc.nextInt();
        return new SavingAccount(name, balance, interestRate);
    }

    private static void transferToSaving(ArrayList<Account> accounts) {
        Scanner sc = new Scanner(System.in);
        printAccounts(accounts);
        System.out.println("Select index of an account to transfer From");
        int transferFromAccount = sc.nextInt();
        System.out.println("Select index of an account to transfer To");
        int transferToAccount = (int) sc.nextDouble();

        System.out.println("How much you want to transfer?");
        int amount = (int) sc.nextDouble();
        if (accounts.get(transferFromAccount).getBalance() >= amount) {
            Account sav = accounts.get(transferToAccount);
            sav.transferTo(accounts.get(transferFromAccount),accounts.get(transferToAccount),amount);
            accounts.get(transferFromAccount).withdraw(amount);
            System.out.println("Transfer successfully!");
        } else {
            System.out.println("Not enough balance");
        }
    }
}
