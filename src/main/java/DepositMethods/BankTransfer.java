package DepositMethods;


import Account.Account;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class BankTransfer{
    public static HashMap<String, String> bankMap = new HashMap<>();


    public static void add(){
        bankMap.put("John Doe", "82457301964823756948273691");
        bankMap.put("Ronnie Coleman","15379046281564739024816357");
        bankMap.put("Joe Weider", "49285670391574628395176428");
    }

    public  static void deposit(Account loggedInAccount) {
            Scanner scanner = new Scanner(System.in);
            do {
                add();
                System.out.println(bankMap);


                System.out.println("Please enter the account number");
                String accountNumber = scanner.nextLine();

                System.out.println("Please enter the account holder name");
                String accountHolder = scanner.nextLine();

                System.out.println("Please enter the amount");
                int amount = scanner.nextInt();

                if (accountNumber.equals(bankMap.get(accountHolder))) {
                    loggedInAccount.setBalance(amount + loggedInAccount.getBalance());
                    System.out.println("Deposit has been successfully made \n" +
                            "New Balance : " + loggedInAccount.getBalance());
                    break;
                } else {
                    System.out.println("Account number does not match");
                    System.out.println("Would you like to try again ? \n" +
                            "Press 1 to try again, Press 2 to Exit");
                    int isAgain = scanner.nextInt();
                    if (isAgain != 1){
                        break;
                    }
                }


            }while (true);

    }
}