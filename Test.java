import javax.swing.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        String wal = "";
        JOptionPane.showMessageDialog(null , "===============   WELCOME TO MY BANKING WALLET SYSTEM   ===============");
        wal = JOptionPane.showInputDialog(null , "ENTER THE NUMBER OF ACCOUNTS YOU WANT TO OPEN WALLETS FOR THEM ");
        if (wal == null){
            JOptionPane.showMessageDialog(null, "THE PROGRAM END ");
            System.exit(0);
        }
        Account a[] = new Account[Integer.parseInt(wal)];
        Account obj = new Account();
        Customer c [] = new Customer[Integer.parseInt(wal)];
        Customer c2 [];
        Service service = new Service();

        Account s;
        previous p = new Account();
        double previousTrans = 0.0;
        //SavingAccount saving [] = new SavingAccount[2];//
        SavingAccount savObj = new SavingAccount();
        double amount;
        double monthlyRate = 0.0;
        String id = "";
        String answer2;
        boolean check, answer;
        String balance = "";
        double savMonthlyRate = 0.0;
        int choice;
        String mobile;
        JOptionPane.showMessageDialog(null , "PLEASE ENTER YOUR ACCOUNT DATA TO OPEN A WALLET " ,"ENTERING DATA" ,  JOptionPane.INFORMATION_MESSAGE);
        for (int i = 0; i < a.length; i++) {
            JOptionPane.showMessageDialog(null , " ============== WALLET " +(i+1) + " ============== ");
            System.out.println();

            String name = "";
            name = JOptionPane.showInputDialog(null , "================ ENTER YOUR NAME ================" , "NAME" , JOptionPane.DEFAULT_OPTION);
            if (name!= null){
                c[i] = new Customer();
                c[i].setName(name);
            }
            else {
                JOptionPane.showMessageDialog(null, "THE PROGRAM END ");
                System.exit(0);
            }

            id = (JOptionPane.showInputDialog(null , "================ ENTER YOUR ID ================" , "ID" , JOptionPane.DEFAULT_OPTION));
            if (id == null){
                JOptionPane.showMessageDialog(null, "THE PROGRAM END ");
                System.exit(0);
            }
            mobile = (JOptionPane.showInputDialog(null , "================ ENTER YOUR MOBILE NUMBER ================" , "MOBILE" , JOptionPane.DEFAULT_OPTION));

            if (mobile == null){
                JOptionPane.showMessageDialog(null, "THE PROGRAM END ");
                System.exit(0);
            }
            balance = (JOptionPane.showInputDialog(null , "================ ENTER YOUR BALANCE ================" , "BALANCE" , JOptionPane.DEFAULT_OPTION));
            if (balance == null){
                JOptionPane.showMessageDialog(null, "THE PROGRAM END ");
                System.exit(0);
            }

            a[i] = new Account(Integer.parseInt(id), Double.parseDouble(balance) , mobile);
            a[i].setId(Integer.parseInt(id));
            a[i].setMobile(mobile);
            a[i].setBalance(Double.parseDouble(balance));
            a[i].setAnnualInterestRate(4.5);
            a[i].getId();
            a[i].getBalance();
            a[i].getAnnualInterestRate();
            monthlyRate = a[i].getMonthlyInterestRate();
            a[i].getMonthlyInterest(monthlyRate);

        }
        System.out.println();

        int size = 0;
        size = Integer.parseInt(JOptionPane.showInputDialog(null , "ENTER THE NUMBER OF CUSTOMERS HAVING SAVING ACCOUNTS " , size));
        c2 = new Customer[size];
        SavingAccount saving [] = new SavingAccount[size];
        for (int i = 0; i < c2.length; i++) {
         String saveName = "";
         saveName = JOptionPane.showInputDialog(null , "================ ENTER YOUR NAME ================" , "NAME" , JOptionPane.DEFAULT_OPTION);
         if (saveName == null){
             JOptionPane.showMessageDialog(null, "THE PROGRAM END ");
             System.exit(0);
         }
         c2[i] = new Customer();
         c2[i].setName(saveName);
         String savId = "";
         savId = (JOptionPane.showInputDialog(null , "================ ENTER YOUR ID ================" , "ID" , JOptionPane.DEFAULT_OPTION));
         if (savId == null){
             JOptionPane.showMessageDialog(null, "THE PROGRAM END ");
              System.exit(0);
         }
         String savBalance = "";
         savBalance = (JOptionPane.showInputDialog(null , "================ ENTER YOUR SAVING ACCOUNT BALANCE ================" , "BALANCE" , JOptionPane.DEFAULT_OPTION));
         if (savBalance == null){
            JOptionPane.showMessageDialog(null, "THE PROGRAM END ");
            System.exit(0);
         }
         saving[i] = new SavingAccount();
         saving[i].setId(Integer.parseInt(savId));
         saving[i].setSaveBalance(Double.parseDouble(savBalance));

         saving[i].setAnnualInterestRate(6.5);
         savMonthlyRate = saving[i].getMonthlyInterestRate();
         saving[i].getMonthlyInterest(savMonthlyRate);

        }

        service.setAccount(a);

        do {
            System.out.println();
            System.out.println("1. Show the data ");
            System.out.println("2. withdraw ");
            System.out.println("3. deposit ");
            System.out.println("4. show saving account data ");
            System.out.println("5. withdraw for saving account");
            System.out.println("6. deposit for saving account");
            System.out.println("7. send a money to specified wallet ");
            System.out.println("8. request a money form specified wallet ");
            System.out.println("9. previous transaction ");
            System.out.println("10. previous transaction for saving accounts ");
            System.out.println();

            Account obj2;
            SavingAccount savObj2;

            choice = input.nextInt();
            switch (choice) {
                case 1:
                    obj.showData(a, monthlyRate , c);
                    TimeUnit.SECONDS.sleep(3);
                    answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                    String s1 = new String(answer2);
                    check = s1.equalsIgnoreCase("yes");
                    if (check) {
                        answer = true;
                        break;
                    } else {
                        answer = false;
                        JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                        break;
                    }

                case 2:
                    obj2 = obj.search(a);
                    if (obj2 == null){
                        JOptionPane.showMessageDialog(null , "INVALID ID!.. PLEASE TRY AGAIN " ,"WARNING " ,  JOptionPane.WARNING_MESSAGE);
                        answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                        String s2 = new String(answer2);
                        check = s2.equalsIgnoreCase("yes");
                        if (check) {
                            answer = true;
                            break;
                        } else {
                            answer = false;
                            JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                            break;
                        }
                    }
                    else {
                        System.out.println("ENTER THE AMOUNT YOU WANT TO WITHDRAW ");
                        amount = input.nextDouble();
                        System.out.println();
                        double b = obj2.withdraw(amount);
                        if (b > amount)
                            previousTrans = - amount;
                        obj2.setPreviousTransaction(previousTrans);
                        System.out.println("YOUR DATA AFTER WITHDRAW ");
                        obj2.showData(a, monthlyRate , c);
                        TimeUnit.SECONDS.sleep(3);
                        answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                        String s2 = new String(answer2);
                        check = s2.equalsIgnoreCase("yes");
                        if (check) {
                            answer = true;
                            break;
                        } else {
                            answer = false;
                            JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                            break;
                        }
                    }

                case 3:
                    obj2 = obj.search(a);
                    if (obj2 == null){
                        JOptionPane.showMessageDialog(null , "INVALID ID!.. PLEASE TRY AGAIN " ,"WARNING " ,  JOptionPane.WARNING_MESSAGE);
                        answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                        String s3 = answer2;
                        check = s3.equalsIgnoreCase("yes");
                        if (check) {
                            answer = true;
                            break;
                        } else {
                            answer = false;
                            JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                            break;
                        }
                    }
                    else {
                        System.out.println("ENTER THE AMOUNT YOU WANT TO DEPOSIT ");
                        amount = input.nextDouble();
                        previousTrans = amount;
                        obj2.deposit(amount);
                        obj2.setPreviousTransaction(previousTrans);
                        obj2.showData(a, monthlyRate , c);
                        TimeUnit.SECONDS.sleep(3);
                        answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                        String s3 = answer2;
                        check = s3.equalsIgnoreCase("yes");
                        if (check) {
                            answer = true;
                            break;
                        } else {
                            answer = false;
                            JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                            break;
                        }
                    }
                case 4:
                    savObj.showData(saving, savMonthlyRate , c2);
                    TimeUnit.SECONDS.sleep(3);
                    answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                    String s5 = answer2;
                    check = s5.equalsIgnoreCase("yes");
                    if (check) {
                        answer = true;
                        break;
                    } else {
                        answer = false;
                        JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                        break;
                    }
                case 5:
                    savObj2 = savObj.saveSearch(saving);
                    if (savObj2 == null){
                        JOptionPane.showMessageDialog(null , "INVALID ID!.. PLEASE TRY AGAIN " ,"WARNING " ,  JOptionPane.WARNING_MESSAGE);
                        answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                        String s6 = answer2;
                        check = s6.equalsIgnoreCase("yes");
                        if (check) {
                            answer = true;
                            break;
                        } else {
                            answer = false;
                            JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                            break;
                        }
                    }
                    else{
                        System.out.println("Enter the amount you want to withdraw ");
                        double amount2 = input.nextDouble();
                        savObj2.withdraw(amount2);
                        previousTrans = - amount2;
                        savObj2.setPreviousTransaction(previousTrans);
                        System.out.println("Your data after withdraw ");
                        savObj2.showData(saving, savMonthlyRate , c2);
                        TimeUnit.SECONDS.sleep(3);
                        answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                        String s6 = answer2;
                        check = s6.equalsIgnoreCase("yes");
                        if (check) {
                            answer = true;
                            break;
                        } else {
                            answer = false;
                            JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                            break;
                        }
                    }
                case 6:

                    savObj2 = savObj.saveSearch(saving);
                    if (savObj2 == null){
                        JOptionPane.showMessageDialog(null , "INVALID ID!.. PLEASE TRY AGAIN " ,"WARNING " ,  JOptionPane.WARNING_MESSAGE);
                        answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                        String s7 = answer2;
                        check = s7.equalsIgnoreCase("yes");
                        if (check) {
                            answer = true;
                            break;
                        } else {
                            answer = false;
                            JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                            break;
                        }
                    }
                    else{
                        System.out.println("ENTER THE AMOUNT YOU WANT TO DEPOSIT ");
                        double amount3 = input.nextDouble();
                        savObj2.deposit(amount3);
                        previousTrans = amount3;
                        savObj2.setPreviousTransaction(previousTrans);
                        System.out.println("YOUR DATA AFTER DEPOSIT ");
                        savObj2.showData(saving, savMonthlyRate , c2);
                        TimeUnit.SECONDS.sleep(3);
                        answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                        String s7 = answer2;
                        check = s7.equalsIgnoreCase("yes");
                        if (check) {
                            answer = true;
                            break;
                        } else {
                            answer = false;
                            JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                            break;
                        }
                    }
                case 7:
                    s = new Service();
                    System.out.println("ENTER THE AMOUNT YOU WANT TO SEND ");
                    double am = input.nextDouble();

                    s = service.checkId(a);
                    if (s == null){
                        JOptionPane.showMessageDialog(null , "INVALID DATA!.. PLEASE TRY AGAIN " ,"WARNING " ,  JOptionPane.WARNING_MESSAGE);
                        answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                        String s8 = answer2;
                        check = s8.equalsIgnoreCase("yes");
                        if (check) {
                            answer = true;
                            break;
                        } else {
                            answer = false;
                            JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                            break;
                        }
                    }
                    else {
                        s.withdraw(am);
                        s = service.search(a);
                        if (s == null){
                            JOptionPane.showMessageDialog(null , "INVALID DATA!.. PLEASE TRY AGAIN " ,"WARNING " ,  JOptionPane.WARNING_MESSAGE);
                            answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                            String s8 = answer2;
                            check = s8.equalsIgnoreCase("yes");
                            if (check) {
                                answer = true;
                                break;
                            } else {
                                answer = false;
                                JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                                break;
                            }
                        }
                        else {
                            s.sendMoney(am);
                            s.showData(a , monthlyRate , c);
                            TimeUnit.SECONDS.sleep(3);
                            answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                            String s8 = answer2;
                            check = s8.equalsIgnoreCase("yes");
                            if (check) {
                                answer = true;
                                break;
                            } else {
                                answer = false;
                                JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                                break;
                            }
                        }
                    }
                case 8:
                    System.out.println("ENTER THE AMOUNT YOU WANT TO REQUEST ");
                    double request = input.nextDouble();
                    System.out.println("ENTER THE ACCOUNT'S ID YOU WANT TO REQUEST THE MONEY  ");
                    int requestId = input.nextInt();
                    System.out.println("ENTER THE MOBILE NUMBER ");
                    mobile = input.next();
                    s = service.search(a , requestId , mobile);
                    if (s == null){
                        JOptionPane.showMessageDialog(null , "INVALID DATA!.. PLEASE TRY AGAIN " ,"WARNING " ,  JOptionPane.WARNING_MESSAGE);
                        answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                        String s9 = answer2;
                        check = s9.equalsIgnoreCase("yes");
                        if (check) {
                            answer = true;
                            break;
                        } else {
                            answer = false;
                            JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                            break;
                        }
                    }
                    else {
                        System.out.println("DO YOU ACCEPT THIS REQUEST ? ");
                        String ans = input.next();
                        if (ans.equalsIgnoreCase("yes")){
                            double b = s.withdraw(request);
                            if (b < request){
                                JOptionPane.showMessageDialog(null , "THE PROCCESS FAILED " ,"FAILED " ,  JOptionPane.WARNING_MESSAGE);
                                answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                                String s9 = answer2;
                                check = s9.equalsIgnoreCase("yes");
                                if (check) {
                                    answer = true;
                                    break;
                                } else {
                                    answer = false;
                                    JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                                    break;
                                }
                            }
                            else {
                                System.out.println("ENTER THE ACCOUNT'S ID YOU WANT TO RECEIVE THE REQUESTED MONEY ");
                                requestId = input.nextInt();
                                System.out.println("ENTER THE MOBILE NUMBER ");
                                mobile = input.next();
                                s = service.checkId(a , requestId , mobile);
                                if (s == null){
                                    JOptionPane.showMessageDialog(null , "INVALID ID!.. PLEASE TRY AGAIN " ,"WARNING " ,  JOptionPane.WARNING_MESSAGE);
                                    answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                                    String s9 = answer2;
                                    check = s9.equalsIgnoreCase("yes");
                                    if (check) {
                                        answer = true;
                                        break;
                                    } else {
                                        answer = false;
                                        JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                                        break;
                                    }
                                }
                                else {
                                    s.sendMoney(request);
                                    s.showData(a , monthlyRate , c);
                                    TimeUnit.SECONDS.sleep(3);
                                    answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                                    String s9 = answer2;
                                    check = s9.equalsIgnoreCase("yes");
                                    if (check) {
                                        answer = true;
                                        break;
                                    } else {
                                        answer = false;
                                        JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                                        break;
                                    }
                                }
                            }
                        }
                        else
                            JOptionPane.showMessageDialog(null , "THE PROCESS FAILED " ,"FAILED " ,  JOptionPane.WARNING_MESSAGE);
                    }
                case 9:
                    obj2 = obj.search(a);
                    if (obj2 == null){
                        JOptionPane.showMessageDialog(null , "INVALID DATA! " ,"WARNING " ,  JOptionPane.WARNING_MESSAGE);
                        answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                        String s10 = new String(answer2);
                        check = s10.equalsIgnoreCase("yes");
                        if (check) {
                            answer = true;
                            break;
                        } else {
                            answer = false;
                            JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                            break;
                        }
                    }
                    else {
                        obj2.getTransaction();
                        TimeUnit.SECONDS.sleep(3);
                        answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                        String s10 = new String(answer2);
                        check = s10.equalsIgnoreCase("yes");
                        if (check) {
                            answer = true;
                            break;

                        } else {
                            answer = false;
                            JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                            break;
                        }
                    }
                case 10:
                    System.out.println("ENTER THE ID ");
                    int id3 = input.nextInt();
                    savObj2 = savObj.search(saving , id3);
                    if (savObj2 == null){
                        JOptionPane.showMessageDialog(null , "INVALID ID " ,"WARNING " ,  JOptionPane.WARNING_MESSAGE);
                        answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                        String s11 = new String(answer2);
                        check = s11.equalsIgnoreCase("yes");
                        if (check) {
                            answer = true;
                            break;
                        } else {
                            answer = false;
                            JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                            break;
                        }
                    }
                    else {
                        savObj2.getTransaction();
                        TimeUnit.SECONDS.sleep(3);
                        answer2 = JOptionPane.showInputDialog(null , "YOU WANT ANYTHING ELSE ? " , "ASK" , JOptionPane.QUESTION_MESSAGE);
                        String s11 = new String(answer2);
                        check = s11.equalsIgnoreCase("yes");
                        if (check) {
                            answer = true;
                            break;
                        } else {
                            answer = false;
                            JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                            break;
                        }
                    }

                default:
                    JOptionPane.showMessageDialog(null , "INVALID");
                    JOptionPane.showMessageDialog(null , "YOU WANT ANYTHING ELSE ? ");
                    answer2 = input.next();
                    String s4 = new String(answer2);
                    check = s4.equalsIgnoreCase("yes");
                    if (check) {
                        answer = true;
                        break;
                    } else {
                        answer = false;
                        JOptionPane.showMessageDialog(null , "THANK YOU .... !");
                        break;
                    }
            }


        }while (answer);
    }
}
