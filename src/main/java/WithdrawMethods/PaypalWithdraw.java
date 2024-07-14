package WithdrawMethods;

import Account.Account;

import java.util.Scanner;

public class PaypalWithdraw {

    public static void withdraw(Account loggedInAccount) {

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please enter the Paypal Number");
            String paypalNumber = scanner.nextLine();

            System.out.println("Please enter the amount");
            int amount = scanner.nextInt();

            String trimmedPaypalNumber = paypalNumber.replaceAll("[^0-9]", "");

            System.out.println("Please enter the Paypal Account Holder Name");
            String accountHolderName = scanner.nextLine();


            if (loggedInAccount.getBalance() >= amount) {

                if (trimmedPaypalNumber.length() == 9 && accountHolderName.equals(loggedInAccount.getName())) {

                    loggedInAccount.setBalance(loggedInAccount.getBalance() - amount);
                    System.out.println("Paypal Withdraw has been successfully made \n" +
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
            } else {
                System.out.println("You do not have enough balance to withdraw");
                System.out.println("Would you like to try again ? \n" +
                        "Press 1 to try again, Press 2 to Exit");
                int isAgain = scanner.nextInt();
                if (isAgain != 1) {
                    break;
                }
            }
            break;
        } while (true);

    }
}