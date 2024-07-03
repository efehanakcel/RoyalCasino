package Pages;

import Account.Account;
import Account.AccountMethods;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomePage {

    public static void start() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Press 1 to create an Account");
            System.out.println("Press 2 to Log-In");
            System.out.println("Press 3 to change the password");
            System.out.println("Press 4 to EXIT");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    AccountMethods.createAnAccount();
                    break;

                case 2:
                    Account loggedInAccount = AccountMethods.loggedInAccount(AccountMethods.accountList);
                    if (loggedInAccount == null) {
                        continue;
                    } else {
                        LoggedInPage.loggedInPage(loggedInAccount);
                    }

                    break;

                case 3:

                    //change password methodu yazilacak

                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid number");
                    continue;


            }
            System.out.println("Would you like to continue the process ? \n" +
                    "Enter 1 to continue, 2 for EXIT ");
            int devamMi = scanner.nextInt();
            if (devamMi == 1){
                continue;
            }
            scanner.close();
            break;
        } while (true);
    }
}





