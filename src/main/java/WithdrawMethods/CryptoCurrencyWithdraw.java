package WithdrawMethods;

import Account.Account;

import java.util.Scanner;

public class CryptoCurrencyWithdraw {
    public static void withdraw (Account loggedInAccount){
        Scanner scanner=new Scanner(System.in);
        do{
            System.out.println("Please enter the Wallet Number");
            String walletNumber = scanner.nextLine();
            System.out.println("Please enter the amount");
            int amount = scanner.nextInt();
            if (walletNumber.length() == 34 && walletNumber.startsWith("T"))
            {
                if (amount <= loggedInAccount.getBalance())
                {
                    loggedInAccount.setBalance(loggedInAccount.getBalance()-amount);
                    System.out.println("Withdraw has been successfully made \n" +
                            "New Balance : " + loggedInAccount.getBalance());
                    break;
                }
                else
                {
                    System.out.println("You do not have enough balance to withdraw");
                    System.out.println("Would you like to try again ? \n" +
                            "Press 1 to try again, Press 2 to Exit");
                    int isAgain = scanner.nextInt();
                    if (isAgain != 1) {
                        break;
                    }
                }
            }
            else
            {
                System.out.println("Wallet ID is not valid");
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