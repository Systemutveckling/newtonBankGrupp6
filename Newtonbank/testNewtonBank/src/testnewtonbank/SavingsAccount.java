/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testnewtonbank;

/**
 *
 * @author Joel
 */

/**
 *
 * @author Joel
 */
public class SavingsAccount {
    private double balance;
    private double interestRate;
    private double interest;
    private String accountType;
    private int accountNo;
    private static int accountCounter = 1000;

    public SavingsAccount() {
        balance = 0;
        interestRate = 1;
        accountType = "Savings account";
        accountCounter++;
        accountNo = accountCounter;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interest) {
        this.interestRate = interest;
    }

    public double getInterest() {
        return balance * interestRate / 100;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public static int getAccountCounter() {
        return accountCounter;
    }

    public static void setAccountCounter(int accountCounter) {
        SavingsAccount.accountCounter = accountCounter;
    }
    
    public void deposit(double amount){
        balance += amount; //Lägger till det användaren matade in, till balance
    }
    
    public void withdraw(double amount){
        if(balance - amount >= 0){ //Kollar om det finns tillräckligt med pengar på kontot
            balance -= amount;
        } else {
            System.out.println("Not enough money in your account, you poor bastard!");
        }
    }
    
    @Override
    public String toString(){
        return("Account no: " + accountNo + "\tBalance: " + balance + "\tAccount type: " + accountType + "\tInterest rate: " + interestRate);
    }
}

