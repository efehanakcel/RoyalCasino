package Account;

import java.util.Scanner;

public class PasswordUpdate {


    public static void update(Account loggedInAccount) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please enter the current password");

            String currentPassword = scanner.nextLine();

            if (currentPassword.equals(loggedInAccount.getPassword())) {

                while (true) {
                    System.out.println("Please enter the new password : ");
                    String password = scanner.nextLine();
                    boolean spaceControl = password.replaceAll("[^ ]", "").isEmpty();
                    boolean digitControl = password.length() >= 8;
                    boolean specialCharCnt = password.replaceAll("[^\\p{Punct}]+", "").length() > 0;
                    boolean upperCaseControl = password.replaceAll("[^A-Z]", "").length() > 0;
                    boolean lowerCaseControl = password.replaceAll("[^a-z]", "").length() > 0;

                    if (spaceControl && digitControl && specialCharCnt && upperCaseControl && lowerCaseControl) {
                        loggedInAccount.setPassword(password);
                        System.out.println("Password has been successfully changed.");
                        break;
                    } else
                        System.out.println("Please enter a valid password.");
                    System.out.println("Would you like to try again ? \n" +
                            "Press 1 to try again, Press 2 to Exit");
                    int isAgain = scanner.nextInt();
                    if (isAgain != 1){
                        break;
                    }

                }

            } else {
                System.out.println("Password does not match");
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
