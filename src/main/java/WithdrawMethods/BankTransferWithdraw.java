package WithdrawMethods;

import Account.Account;

import java.util.Scanner;

public class BankTransferWithdraw {

    public  static void withdraw(Account loggedInAccount) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please enter the account number");
            String accountNumber = scanner.nextLine();

            System.out.println("Please enter the amount");
            int amount = scanner.nextInt();

            String trimmedAccountNumber=accountNumber.replaceAll("[^0-9]", "");

            System.out.println("Please enter the account holder name");
            String accountHolder = scanner.nextLine();


            if (loggedInAccount.getBalance() >= amount) {
                if (trimmedAccountNumber.length() == 26 && accountHolder.equals(loggedInAccount.getName())) {
                    trimmedAccountNumber = "TR" + trimmedAccountNumber;
                    System.out.println(trimmedAccountNumber);
                    loggedInAccount.setBalance(loggedInAccount.getBalance() - amount);
                    System.out.println("Withdraw has been successfully made \n" +
                            "New Balance : " + loggedInAccount.getBalance());
                    break;
                } else {
                    System.out.println("Account number does not match");
                    System.out.println("Would you like to try again ? \n" +
                            "Press 1 to try again, Press 2 to Exit");
                    int isAgain = scanner.nextInt();
                    if (isAgain != 1) {
                        break;
                    }
                }
            }else {
                System.out.println("You do not have enough balance to withdraw");
                System.out.println("Would you like to try again ? \n" +
                        "Press 1 to try again, Press 2 to Exit");
                int isAgain = scanner.nextInt();
                if (isAgain != 1) {
                    break;
                }
            }

        }while (true);

    }
}