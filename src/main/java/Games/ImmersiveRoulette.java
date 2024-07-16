package Games;

import Account.Account;

import java.util.*;

public class ImmersiveRoulette{

    public static void play(Account loggedInAccount) {

        List<Integer> redNumbers = new ArrayList<>();
        List<Integer> blackNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> firstColumn = new ArrayList<>();
        List<Integer> secondColumn = new ArrayList<>();
        List<Integer> thirdColumn = new ArrayList<>();
        List<Integer> firstDozen = new ArrayList<>();
        List<Integer> secondDozen = new ArrayList<>();
        List<Integer> thirdDozen = new ArrayList<>();
        int green = 0;
        for (int i = 1; i < 37; i++) {
            if (i < 13) {
                firstDozen.add(i);
            } else if (i <= 24) {
                secondDozen.add(i);
            } else {
                thirdDozen.add(i);
            }
            if (i % 3 == 1) {
                firstColumn.add(i);
            } else if (i % 3 == 2) {
                secondColumn.add(i);
            } else {
                thirdColumn.add(i);
            }
            if (i % 2 == 0) {
                redNumbers.add(i);
                evenNumbers.add(i);
            } else {
                blackNumbers.add(i);
                oddNumbers.add(i);
            }
        }
        HashMap<Integer, Double> betHash = new HashMap<>();
        do {

            Scanner scanner = new Scanner(System.in);
            List<Double> totalAmount = new ArrayList<>();

            System.out.println("Press 1 to bet on a number");
            System.out.println("Press 2 to bet on '0' ");
            System.out.println("Press 3 to bet on Red");
            System.out.println("Press 4 to bet on Black");
            System.out.println("Press 5 to bet on Even");
            System.out.println("Press 6 to bet on Odd");
            System.out.println("Press 7 to bet on 1st Column");
            System.out.println("Press 8 to bet on 2nd Column");
            System.out.println("Press 9 to bet on 3rc Column");
            System.out.println("Press 10 to bet on Dozen (1-12");
            System.out.println("Press 11 to bet on Dozen (13-24");
            System.out.println("Press 12 to bet on Dozen (25-36");
            int betType = scanner.nextInt();

            int result = generateRandomNumber();

                switch (betType) {
                    case 1:
                        while (true) {
                            System.out.println("Please enter the number OR -1 to return to the Bet List");
                            int betNumber = scanner.nextInt();

                            // Exit the loop if the user enters -1
                            if (betNumber == -1) {
                                break;
                            } else {
                                // Ask for the bet amount and store it in the HashMap
                                System.out.println("Please enter the amount");
                                double betAmount = scanner.nextInt();
                                betHash.put(betNumber, betAmount);

                                // Debug print to confirm values are being added
                                System.out.println("Added bet: " + betNumber + " with amount: " + betAmount);

                                // Consume the newline character left over by nextInt()
                                scanner.nextLine();
                            }
                        }
                        continue;

                    case 2:
                        System.out.println("Please enter the amount");
                        double betAmount = scanner.nextInt();
                        betHash.put(green, betAmount);

                        if (isContinue()) {
                            continue;
                        }
                        break;

                    case 3:
                        System.out.println("Please enter the amount");
                        double redBetAmount = scanner.nextInt();
                        for (Integer number : redNumbers) {
                            betHash.put(number, betHash.getOrDefault(number, 0.0) + redBetAmount / 18);
                        }
                        if (isContinue()) {
                            continue;
                        }
                        break;
                    case 4:
                        System.out.println("Please enter the amount");
                        double blackBetAmount = scanner.nextInt();

                        for (Integer number : blackNumbers) {
                            if (betHash.containsKey(number)) {
                                betHash.put(number, blackBetAmount / 18 + betHash.get(number));
                            } else {
                                betHash.put(number, blackBetAmount / 18);
                            }
                        }
                        if (isContinue()) {
                            continue;
                        }
                        break;
                    case 5:
                        System.out.println("Please enter the amount");
                        double evenBetAmount = scanner.nextInt();

                        for (Integer number : evenNumbers) {
                            if (betHash.containsKey(number)) {
                                betHash.put(number, evenBetAmount / 18 + betHash.get(number));
                            } else {
                                betHash.put(number, evenBetAmount / 18);
                            }
                        }
                        if (isContinue()) {
                            continue;
                        }
                        break;
                    case 6:
                        System.out.println("Please enter the amount");
                        double oddBetAmount = scanner.nextInt();

                        for (Integer number : oddNumbers) {
                            if (betHash.containsKey(number)) {
                                betHash.put(number, oddBetAmount / 18 + betHash.get(number));
                            } else {
                                betHash.put(number, oddBetAmount / 18);
                            }
                        }
                        if (isContinue()) {
                            continue;
                        }
                        break;
                    case 7:
                        System.out.println("Please enter the amount");
                        double firstColumnBet = scanner.nextInt();

                        for (Integer number : firstColumn) {
                            if (betHash.containsKey(number)) {
                                betHash.put(number, firstColumnBet / 12 + betHash.get(number));
                            } else {
                                betHash.put(number, firstColumnBet / 12);
                            }
                        }
                        if (isContinue()) {
                            continue;
                        }
                        break;
                    case 8:
                        System.out.println("Please enter the amount");
                        double secondColumnBet = scanner.nextInt();

                        for (Integer number : secondColumn) {
                            if (betHash.containsKey(number)) {
                                betHash.put(number, secondColumnBet / 12 + betHash.get(number));
                            } else {
                                betHash.put(number, secondColumnBet / 12);
                            }
                        }
                        if (isContinue()) {
                            continue;
                        }
                        break;
                    case 9:
                        System.out.println("Please enter the amount");
                        double thirdColumnBet = scanner.nextInt();

                        for (Integer number : thirdColumn) {
                            if (betHash.containsKey(number)) {
                                betHash.put(number, thirdColumnBet / 12 + betHash.get(number));
                            } else {
                                betHash.put(number, thirdColumnBet / 12);
                            }
                        }
                        if (isContinue()) {
                            continue;
                        }
                        break;
                    case 10:
                        System.out.println("Please enter the amount");
                        double firstDozenBet = scanner.nextInt();

                        for (Integer number : firstDozen) {
                            if (betHash.containsKey(number)) {
                                betHash.put(number, firstDozenBet / 12 + betHash.get(number));
                            } else {
                                betHash.put(number, firstDozenBet / 12);
                            }
                        }
                        if (isContinue()) {
                            continue;
                        }
                        break;
                    case 11:
                        System.out.println("Please enter the amount");
                        double secondDozenBet = scanner.nextInt();

                        for (Integer number : secondDozen) {
                            if (betHash.containsKey(number)) {
                                betHash.put(number, secondDozenBet / 12 + betHash.get(number));
                            } else {
                                betHash.put(number, secondDozenBet / 12);
                            }
                        }
                        if (isContinue()) {
                            continue;
                        }
                        break;
                    case 12:
                        System.out.println("Please enter the amount");
                        double thirdDozenBet = scanner.nextInt();
                        for (Integer number : thirdDozen) {
                            if (betHash.containsKey(number)) {
                                betHash.put(number, thirdDozenBet / 12 + betHash.get(number));
                            } else {
                                betHash.put(number, thirdDozenBet / 12);
                            }
                        }
                        if (isContinue()) {
                            continue;
                        }
                        break;
                    default:
                        System.out.println("Please enter a valid value");

                }
            int totalBet = 0;
            for (Double amount : betHash.values()) {
                totalAmount.add(amount);
                totalBet += amount;
            }
            System.out.println("------------------ HASH CONTROL");

                for (Integer m : betHash.keySet()){
                    System.out.print(m);
                    System.out.println(betHash.get(m));
                }
            System.out.println(totalAmount);



                if (betHash.containsKey(result)) {
                    double amountWon = betHash.get(result) * 36;
                    loggedInAccount.setBalance(loggedInAccount.getBalance() - totalBet + amountWon);
                    System.out.println("Congratulations ! You won :  " + amountWon);
                    System.out.println("Total Bet : " + totalBet);
                    System.out.println("Bet Won : " + result);
                    System.out.println("New Balance : " + loggedInAccount.getBalance());
                } else {
                    loggedInAccount.setBalance(loggedInAccount.getBalance() - totalBet);
                    System.out.println("You have lost");
                    System.out.println("Total Bet : " + totalBet);
                    System.out.println("Bet Won : " + result);
                    System.out.println("New Balance : " + loggedInAccount.getBalance());
                }
                break;

        }while (true) ;



    }
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(37);


    }
    public static boolean isContinue(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to continue to bet ? \n" +
                "Enter Yes to continue, No for EXIT ");
        String devamMi = scanner.nextLine();
        devamMi.toLowerCase();
        if (devamMi.equals("yes")) {
            return true;
        }
        return false;
    }
}




