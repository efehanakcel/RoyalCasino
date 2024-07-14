package DepositMethods;

import Account.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CryptoCurrency {
    public static List<String> cryptoWalletList = new ArrayList<>();

    public static void generateRandomString() {
        int length = 34;
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        Random random = new Random();

        // Append remaining random characters
        for (int i = 0; i < 3; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append('T');
            for (int j = 1; j < length; j++) {
                char c = chars[random.nextInt(chars.length)];
                sb.append(c);
            }
            cryptoWalletList.add(sb.toString());
        }

    }


    public static void deposit(Account loggedInAccount) {
        Scanner scanner = new Scanner(System.in);
        int dolLar = 34;
        int euro = 37;
        generateRandomString();
        do {

            System.out.println("Crypto Wallet List : " + cryptoWalletList);

            System.out.print("Please enter the TRC-20 Wallet Address: ");

            String walletAddress = scanner.nextLine();

            System.out.println("1.Dollar: " + dolLar + "\n2.Euro: " + euro + "\nSelect the currency you want to trade with: ");
            int select = scanner.nextInt();

            System.out.println("Please enter the amount you would like to transfer");
            int amount = scanner.nextInt();


            for (String w : cryptoWalletList) {
                if (walletAddress.equals(w)) {
                    if (select == 1) {
                        loggedInAccount.setBalance((amount * dolLar) + loggedInAccount.getBalance());
                        System.out.println("Transfer has been successfully completed.");
                        System.out.println("New Balance : " + loggedInAccount.getBalance());
                        break;
                    } else if (select == 2) {
                        loggedInAccount.setBalance((amount * euro) + loggedInAccount.getBalance());
                        System.out.println("Transfer has been successfully completed.");
                        System.out.println("New Balance : " + loggedInAccount.getBalance());
                        break;
                    } else {
                        System.out.println("Please enter a valid value");
                    }

                }
            }
            System.out.println("Account number does not match");
            System.out.println("Would you like to try again ? \n" +
                    "Press 1 to try again, Press 2 to Exit");
            int isAgain = scanner.nextInt();
            if (isAgain == 1) {
                continue;
            }
            break;


        }while (true) ;



    }
}
