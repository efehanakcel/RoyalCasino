package DepositMethods;


import Account.Account;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class BankTransfer{

    public  static void deposit(Account loggedInAccount) {
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println(BankTransferMapped.bankMap);
                BankTransferMapped.add();

                System.out.println("Please enter the account number");
                String accountNumber = scanner.nextLine();
                scanner.nextLine();

                System.out.println("Please enter the account holder name");
                String accountHolder = scanner.nextLine();
                scanner.nextLine();
                System.out.println("Please enter the amount");
                int amount = scanner.nextInt();

                if (accountNumber.equals(BankTransferMapped.bankMap.get(accountHolder))) {
                    loggedInAccount.setBalance(amount + loggedInAccount.getBalance());
                    System.out.println("Deposit has been successfully made \n" +
                            "New Balance : " + loggedInAccount.getBalance());
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