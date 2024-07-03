package DepositMethods;

import Account.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Paypal {
   public static HashMap<String, String> accountNumbers = new HashMap<>();


   public static void add(){
       accountNumbers.put("Jeff Seid", "229534877");
       accountNumbers.put("Arnold Schwarzenegger", "221234877");
       accountNumbers.put("Phil Heath", "651234877");
       accountNumbers.put("Franco Columbu", "453534877");
       accountNumbers.put("Frank Zane", "229534794");
   }

    public static void deposit(Account loggedInAccount) {
        Scanner scanner = new Scanner(System.in);
        do {


            add();
            System.out.println("Paypal Account List : \n" + accountNumbers);

            System.out.println("Please enter the paypal number you would like to transfer");

            String paypalNumber = scanner.nextLine();

            System.out.println("Please enter the account holder you would like to transfer");

            String accountHolder = scanner.nextLine();

            System.out.println("Please enter the amount you would like to transfer");
            int amount = scanner.nextInt();

            if (paypalNumber.equals(accountNumbers.get(accountHolder))) {
                loggedInAccount.setBalance(loggedInAccount.getBalance() + amount);
                System.out.println("Transfer has been successfully made \n" +
                        "New Balance : " + loggedInAccount.getBalance());
            } else {
                System.out.println("Account number does not match");
                System.out.println("Would you like to try again ? \n" +
                        "Press 1 to try again, Press 2 to Exit");
                int isAgain = scanner.nextInt();
                if (isAgain != 1) {
                    break;
                }

            }
        } while (true);
    }












}
