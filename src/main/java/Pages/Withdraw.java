package Pages;

import Account.Account;
import DepositMethods.BankTransfer;
import DepositMethods.CreditCard;
import DepositMethods.CryptoCurrency;
import DepositMethods.Paypal;
import WithdrawMethods.BankTransferWithdraw;
import WithdrawMethods.CryptoCurrencyWithdraw;
import WithdrawMethods.PaypalWithdraw;

import java.util.Scanner;

public class Withdraw {
    public static void withdraw(Account loggedInAccount) {
        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Press 1 to withdraw via Bank Transfer");
            System.out.println("Press 2 to withdraw via Crypto Currency");
            System.out.println("Press 3 to withdraw via Paypal");

            int choiceMethod = scanner.nextInt();
            switch (choiceMethod) {
                case 1:
                    BankTransferWithdraw.withdraw(loggedInAccount);
                    break;
                case 2:
                    CryptoCurrencyWithdraw.withdraw(loggedInAccount);
                    break;
                case 3:
                    PaypalWithdraw.withdraw(loggedInAccount);
                    break;

                default:
                    System.out.println("Please enter a valid value");


            }
            break;

        } while (true);
    }
}
