package DepositMethods;

import Account.Account;

import java.util.Scanner;

public class CreditCard {
    public static void deposit(Account loggedInAccount) {
        String regex = "^(?:4[0-9]{12}(?:[0-9]{3})?" +       // Visa
                "|  5[1-5][0-9]{14}" +               // MasterCard
                "|  3[47][0-9]{13}" +                // American Express
                "|  3(?:0[0-5]|[68][0-9])[0-9]{11}" +// Diners Club
                "|  6(?:011|5[0-9]{2})[0-9]{12}" +   // Discover
                "|  (?:2131|1800|35\\d{3})\\d{11}" + // JCB
                ")(?:[\\s-]?[0-9]{4})*$";

        String regex2 = "^(0[1-9]|1[0-2])/([0-9]{2})$";

        String regex3 = "^\\d{3}$";


        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your credit card number");
        String cardNumber = scanner.nextLine();
        System.out.println("Please enter the expiration date");
        String expDate = scanner.nextLine();
        System.out.println("Please enter the CVV Code");
        String cvvCode = scanner.nextLine();
        System.out.println("Please enter the amount you would like to transfer :");
        int amount = scanner.nextInt();

        if(cardNumber.matches(regex) && expDate.matches(regex2) && cvvCode.matches(regex3)){
            loggedInAccount.setBalance(loggedInAccount.getBalance() + amount);
            System.out.println("Session successfully completed.");
            System.out.println("New Balance : " + loggedInAccount.getBalance());
        }


    }
}
