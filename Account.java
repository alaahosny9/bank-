import javax.swing.*;
import java.util.Scanner;

public class Account extends previous{
    private int id;
    public double balance;
    private String mobile;
    public static double annualInterestRate;
    private Customer [] customers;
    private previous p;
    private double previousTransaction;

    Account(){
    }

    Account(int id , double balance , String mobile){
        this.id = id;
        this.balance = balance;
        this.mobile = mobile;
    }

    public void setPreviousTransaction(double previousTransaction) {
        this.previousTransaction = previousTransaction;
    }

    public double getPreviousTransaction() {
        return previousTransaction;
    }



    public void getTransaction() {
        super.getTransaction(previousTransaction);
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public int getId(){
        return id;
    }
    public double getBalance(){
        return balance;
    }
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public double getMonthlyInterestRate(){
        double rate = annualInterestRate / 100;
        double monthlyInterestRate = rate / 12;
        return monthlyInterestRate;
    }

    public double getMonthlyInterest(double monthlyRate){
        double monthlyInterest = balance * monthlyRate;
        return monthlyInterest;
    }
    public double withdraw(double amount){
        if (amount > balance){
            JOptionPane.showMessageDialog(null , "SORRY YOUR BALANCE IS INSUFFICIENT " ,"WARNING" ,  JOptionPane.WARNING_MESSAGE);
        }else{
            balance = balance - amount;
        }
        return balance;
    }
    public double deposit(double amount){
        if (amount < 50){
            System.out.println("PLEASE ENTER AN AMOUNT ABOVE OR EQUALS 50 \n");
        }
        else {
            System.out.println("YOUR DATA AFTER DEPOSIT \n");
            balance = balance + amount;
            return balance;
        }
        return balance;
    }

    public void showData(Account arr [] , double monthlyRate , Customer customers[]){
        System.out.println("THE ACCOUNT'S WALLET DATA \n");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("================= WALLET " +(i+1) +" =================");
            System.out.println("NAME : " + customers[i].getName());
            System.out.println("ID : " + arr[i].getId());
            System.out.println("MOBILE NUMBER : " + arr[i].getMobile());
            System.out.println("BALANCE : " + arr[i].getBalance());
            System.out.println("THE MONTHLY INTEREST : " + arr[i].getMonthlyInterest(monthlyRate));
        }
    }

    public double sendMoney(double amount){
        balance += amount;
        return balance;
    }

    public Account search(Account arr[]){
        int choice;
        Account a1 = null;
        Scanner input = new Scanner(System.in);
        System.out.println("ENTER THE ID FOR THE ACCOUNT  ");
        choice = input.nextInt();
        System.out.println("ENTER THE MOBILE NUMBER ");
        String mobile = input.next();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getId() == choice && mobile.equals(arr[i].getMobile())){
                a1 = arr[i];
                break;
            }
        }
        return a1;

    }

}
