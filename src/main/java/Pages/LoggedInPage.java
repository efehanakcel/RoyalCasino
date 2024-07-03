package Pages;

import Account.Account;
import DepositMethods.BankTransfer;
import DepositMethods.Paypal;

import java.util.Scanner;

public class LoggedInPage{
    public static void loggedInPage(Account loggedInAccount){

        Scanner scanner = new Scanner(System.in);



        do {
            System.out.println("Press 1 to deposit");
            System.out.println("Press 2 to withdraw money");
            System.out.println("Press 3 to see Casino Games");
            System.out.println("Press 4 to see Slot Games");
            System.out.println("Press 5 to see User Information");
            System.out.println("Press 6 to change Password");

            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    Deposit.deposit(loggedInAccount);
                case 2:

                case 3:

                case 4:

                case 5:

                case 6:




                default:
            }




        }while (true);









    }










}
