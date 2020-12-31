import java.util.Scanner;

public class SavingAccount extends Account {
    public double saveBalance;
    Customer customer[];
    private Service [] s;

    SavingAccount(){
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public void setSaveBalance(double saveBalance) {
        this.saveBalance = saveBalance;
    }

    public double getSaveBalance() {
        return saveBalance;
    }

    @Override
    public void setAnnualInterestRate(double annualInterestRate) {
        super.setAnnualInterestRate(annualInterestRate);
    }

    @Override
    public double getAnnualInterestRate() {
        return super.getAnnualInterestRate();
    }

    @Override
    public double getMonthlyInterestRate() {
        double rate = annualInterestRate / 100;
        double monthlyInterestRate = rate / 12;
        return monthlyInterestRate;
    }

    @Override
    public double getMonthlyInterest(double monthlyRate) {
        return super.getMonthlyInterest(monthlyRate);
    }
    public void showData(SavingAccount arr [] , double monthlyRate , Customer saveCustomers[]){
        System.out.println("The Account data ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("================= SAVING ACCOUNT " + (i+1) + " =================");
            System.out.println("Name : " + saveCustomers[i].getName());
            System.out.println("ID : " + arr[i].getId());
            System.out.println("Balance : " + arr[i].getSaveBalance());
            System.out.println("The Monthly Interest : " + arr[i].getMonthlyInterest(monthlyRate));
        }
    }

    public double withdraw(double amount2){

        if (amount2 > saveBalance){
            System.out.println("SORRY YOUR BALANCE IS INSUFFICIENT ");
        }else{
            saveBalance = saveBalance - amount2;
        }
        return saveBalance;
    }
    public double deposit(double amount){
        saveBalance = saveBalance + amount;
        return saveBalance;
    }
    public SavingAccount saveSearch(SavingAccount arr[]){
        int choice;
        SavingAccount s1 = null;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the id of the account ");
        choice = input.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getId() == choice){
                s1 = arr[i];
                break;
            }
            else
                System.out.println("PLEASE ENTER A VALID ID ACCOUNT \n");
        }
        return s1;

    }
}
