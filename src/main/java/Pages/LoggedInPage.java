package Pages;

import Account.Account;
import DepositMethods.BankTransfer;
import DepositMethods.Paypal;
import Account.UserInformation;
import Account.PasswordUpdate;

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
                    break;
                case 2:
                    Withdraw.withdraw(loggedInAccount);
                    break;
                case 3:
                    CasinoGames.getGames(loggedInAccount);
                    break;
                case 4:

                case 5:
                    UserInformation.getInfo(loggedInAccount);
                case 6:
                    PasswordUpdate.update(loggedInAccount);



                default:
            }

            System.out.println("Would you like to continue the process ? \n" +
                    "Enter 1 to continue, 2 for Main Page ");
            int devamMi = scanner.nextInt();
            if (devamMi == 1){
                continue;
            }

            break;


        }while (true);









    }










}
