package Pages;

import Account.Account;
import DepositMethods.BankTransfer;
import DepositMethods.CreditCard;
import DepositMethods.CryptoCurrency;
import DepositMethods.Paypal;

import java.util.Scanner;

public class Deposit {
    public static void deposit(Account loggedInAccount){
        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Press 1 to deposit via Bank Transfer");
            System.out.println("Press 2 to deposit via Crypto Currency");
            System.out.println("Press 3 to deposit via Paypal");
            System.out.println("Press 4 to deposit via Credit Card");

            int choiceMethod = scanner.nextInt();
            switch (choiceMethod){
                case 1:
                    BankTransfer.deposit(loggedInAccount);
                    break;
                case 2:
                    CryptoCurrency.deposit(loggedInAccount);
                    break;
                case 3:
                    CreditCard.deposit(loggedInAccount);
                    break;

                case 4:
                    Paypal.deposit(loggedInAccount);
                    break;
                default:
                    System.out.println("Please enter a valid value");


            }

            break;

        }while (true);
    }
}
