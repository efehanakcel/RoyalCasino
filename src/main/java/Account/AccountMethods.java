package Account;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class AccountMethods {
    public static List<Account> accountList = new ArrayList<>();


    public static void createAnAccount() {

        Scanner scanner = new Scanner(System.in);
        String userName;
        System.out.println("Please enter your username");
        while (true) {

            userName = scanner.nextLine();
            boolean spaceControl = userName.replaceAll("[^ ]", "").isEmpty();
            if (!spaceControl) {
                System.out.println("Username may not contain blank");
                System.out.println("Please enter the username again");
                continue;
            }
            break;
        }

        String password;
        System.out.println("Please enter your passsword");
        while (true) {


            password = scanner.nextLine();
            boolean spaceControl = password.replaceAll("[^ ]", "").isEmpty();
            boolean digitControl = password.length() >= 8;
            boolean specialCharCnt = password.replaceAll("[^\\p{Punct}]+", "").length() > 0;
            boolean upperCaseControl = password.replaceAll("[^A-Z]", "").length() > 0;
            boolean lowerCaseControl = password.replaceAll("[^a-z]", "").length() > 0;

            if (spaceControl && digitControl && specialCharCnt && upperCaseControl && lowerCaseControl) {
                break;
            } else
                System.out.println("Please enter a valid passport.");

        }
        String name;
        while (true) {
            System.out.println("Please enter your name");
            name = scanner.nextLine();
            boolean spaceControl = name.replaceAll("[^ ]", "").isEmpty();
            boolean specialCharCnt = name.replaceAll("[^\\p{Punct}]+", "").isEmpty();
            if (spaceControl && specialCharCnt) {
                break;
            } else

                System.out.println("Name may not contain blank or special character.");
        }

        String surName;
        while (true) {
            System.out.println("Please enter your surname");
            surName = scanner.nextLine();
            boolean spaceControl = surName.replaceAll("[^ ]", "").isEmpty();
            boolean specialCharCnt = surName.replaceAll("[^\\p{Punct}]+", "").isEmpty();
            if (spaceControl && specialCharCnt) {
                break;
            } else
                System.out.println("Surname may not contain blank or special character.");

        }


        String phoneNumber;
        while (true) {
            System.out.println("Please enter your phoneNumber");
            phoneNumber = scanner.nextLine();
            boolean spaceControl = phoneNumber.replaceAll("[^ ]", "").isBlank();
            boolean specialCharCnt = phoneNumber.replaceAll("[^\\p{Punct}]+", "").isEmpty();
            boolean letterControl = phoneNumber.replaceAll("[^\\d-]", "").isEmpty();
            boolean digitControl = phoneNumber.length() == 9;

            if (spaceControl && specialCharCnt && !letterControl && digitControl) {

                break;
            } else
                System.out.println("Please enter a valid phone number");
        }


        String email;
        while (true) {
            System.out.println("Please enter your email");
            email = scanner.nextLine();
            boolean emailControl = email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
            if (emailControl) {
                break;
            } else
                System.out.println("Please enter a valid email address.");
        }


        String identityNumber;
        System.out.println("Please enter your Identity number");
        while (true) {

            identityNumber = scanner.nextLine();
            boolean spaceControl = identityNumber.replaceAll("[^ ]", "").isEmpty();
            boolean specialCharCnt = identityNumber.replaceAll("[^\\p{Punct}]+", "").isEmpty();
            boolean letterControl = identityNumber.replaceAll("[^\\d-]", "").isEmpty();
            boolean digitControl = identityNumber.length() == 11;

            if (spaceControl && specialCharCnt && !letterControl && digitControl) {
                break;
            } else
                System.out.println("Please enter a valid Identity number");
        }


        String birthDate;
        while (true) {
            System.out.println("Please enter your birth date (DD.MM.YYYY)");
            birthDate = scanner.nextLine();
            boolean birthDateControl = birthDate.matches("^(0[1-9]|[1-2][0-9]|3[0-1])\\.(0[1-9]|1[0-2])\\.\\d{4}$");
            if (!birthDateControl) {
                System.out.println("Please enter your birth date in DD.MM.YYYY format");
                continue;
            }
            break;
        }


        Account account = new Account(userName, password, name, surName, phoneNumber, email, identityNumber, birthDate);
        accountList.add(account);


    }


    public static Account loggedInAccount(List<Account> accountList) {
        Scanner scanner = new Scanner(System.in);

        int maxAttempts =3;


        for(int attempt = 0; attempt < maxAttempts; attempt++ ) {
            System.out.println("Please enter your username");
            String enteredUsername = scanner.nextLine();
            System.out.println("Please enter your password");
            String enteredPassword = scanner.nextLine();

            for (Account account : accountList) {
                if (enteredUsername.equals(account.getUsername()) && enteredPassword.equals(account.getPassword())) {
                    return account;
                }
            }
            System.out.println("Wrong username or password");
            System.out.println("Remaining try : " + (2 - attempt));
        }
        return null;
    }










}
