package Games;

import Account.Account;

import java.util.*;

public class LightningRoulette {
    public static void play(Account loggedInAccount) {
        Random random = new Random();
        double multiplier = 20;
        int multiplierNumber = 10;


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
        HashMap<Integer, Double> redHash = new HashMap<>();
        HashMap<Integer, Double> blackHash = new HashMap<>();
        HashMap<Integer, Double> evenHash = new HashMap<>();
        HashMap<Integer, Double> oddHash = new HashMap<>();
        HashMap<Integer, Double> firstColumnHash = new HashMap<>();
        HashMap<Integer, Double> secondColumnHash = new HashMap<>();
        HashMap<Integer, Double> thirdColumnHash = new HashMap<>();
        HashMap<Integer, Double> firstDozenHash = new HashMap<>();
        HashMap<Integer, Double> secondDozenHash = new HashMap<>();
        HashMap<Integer, Double> thirdDozenHash = new HashMap<>();
        double redBetAmount = 0;
        double blackBetAmount = 0;
        double evenBetAmount = 0;
        double oddBetAmount = 0;
        double firstDozenBetAmount = 0;
        double secondDozenBetAmount = 0;
        double thirdDozenBetAmount = 0;
        double firstColumnBetAmount = 0;
        double secondColumnBetAmount = 0;
        double thirdColumnBetAmount = 0;
        boolean isRed = false;
        boolean isBlack = false;
        boolean isEven = false;
        boolean isOdd = false;
        boolean isfirstColumn = false;
        boolean issecondColumn = false;
        boolean isthirdColumn = false;
        boolean isFirstDozen = false;
        boolean isSecondDozen = false;
        boolean isthirdCozen = false;
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
            System.out.println("Press 13 to Play");
            int betType = scanner.nextInt();

            int result = 10;
            double totalBet = 0;

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
                            if(betAmount < loggedInAccount.getBalance())
                            {
                                loggedInAccount.setBalance(loggedInAccount.getBalance() - betAmount);
                            betHash.put(betNumber, betAmount);
                                // Debug print to confirm values are being added
                                System.out.println("Added bet: " + betNumber + " with amount: " + betAmount);
                            totalBet +=betAmount;
                            }else {
                                System.out.println("The balance is not enough to bet !");
                                break;
                            }



                            // Consume the newline character left over by nextInt()
                            scanner.nextLine();
                        }
                    }
                    continue;

                case 2:
                    System.out.println("Please enter the amount");
                    double betAmount = scanner.nextInt();
                    if(betAmount < loggedInAccount.getBalance()) {
                        loggedInAccount.setBalance(loggedInAccount.getBalance() - betAmount);
                        betHash.put(green, betAmount);
                        totalBet += betAmount;
                    }else {
                        System.out.println("The balance is not enough to bet !");
                    }
                    if (isContinue()) {
                        continue;
                    }
                    break;

                case 3:
                    System.out.println("Please enter the amount");
                    redBetAmount = scanner.nextInt();
                    if(redBetAmount < loggedInAccount.getBalance())
                    {
                        for (Integer number : redNumbers) {
                            redHash.put(number, redBetAmount / 18);
                        }
                        loggedInAccount.setBalance(loggedInAccount.getBalance() - redBetAmount);
                    totalBet +=redBetAmount;
                    isRed = true;
                    }else{
                        System.out.println("The balance is not enough to bet !");
                    }
                    if (isContinue()) {
                        continue;
                    }
                    break;
                case 4:
                    System.out.println("Please enter the amount");
                    blackBetAmount = scanner.nextInt();

                    for (Integer number : blackNumbers) {
                        blackHash.put(number, blackBetAmount / 18);
                    }
                    totalBet +=redBetAmount;
                    isBlack = true;

                    if (isContinue()) {
                        continue;
                    }
                    break;
                case 5:
                    System.out.println("Please enter the amount");
                    evenBetAmount = scanner.nextInt();

                    for (Integer number : evenNumbers) {
                        evenHash.put(number, evenBetAmount);
                    }
                    isEven = true;
                    if (isContinue()) {
                        continue;
                    }
                    break;
                case 6:
                    System.out.println("Please enter the amount");
                    oddBetAmount = scanner.nextInt();

                    for (Integer number : oddNumbers) {
                        oddHash.put(number, oddBetAmount);
                    }
                    isOdd = true;
                    if (isContinue()) {
                        continue;
                    }
                    break;
                case 7:
                    System.out.println("Please enter the amount");
                     firstColumnBetAmount = scanner.nextInt();

                    for (Integer number : firstColumn) {
                        firstColumnHash.put(number, firstColumnBetAmount);
                    }
                    isfirstColumn = true;
                    if (isContinue()) {
                        continue;
                    }
                    break;
                case 8:
                    System.out.println("Please enter the amount");
                     secondColumnBetAmount = scanner.nextInt();

                    for (Integer number : secondColumn) {
                        secondColumnHash.put(number, secondColumnBetAmount);
                    }
                    issecondColumn = true;
                    if (isContinue()) {
                        continue;
                    }
                    break;
                case 9:
                    System.out.println("Please enter the amount");
                     thirdColumnBetAmount = scanner.nextInt();

                    for (Integer number : thirdColumn) {
                        thirdColumnHash.put(number, thirdColumnBetAmount);
                    }
                    isthirdColumn = true;
                    if (isContinue()) {
                        continue;
                    }
                    break;
                case 10:
                    System.out.println("Please enter the amount");
                     firstDozenBetAmount = scanner.nextInt();

                    for (Integer number : firstDozen) {
                        firstDozenHash.put(number, firstDozenBetAmount);
                    }
                    isFirstDozen = true;
                    if (isContinue()) {
                        continue;
                    }
                    break;
                case 11:
                    System.out.println("Please enter the amount");
                     secondDozenBetAmount = scanner.nextInt();

                    for (Integer number : secondDozen) {
                        secondDozenHash.put(number, secondDozenBetAmount);
                    }
                    isSecondDozen = true;
                    if (isContinue()) {
                        continue;
                    }
                    break;
                case 12:
                    System.out.println("Please enter the amount");
                    thirdDozenBetAmount = scanner.nextInt();
                    for (Integer number : thirdDozen) {
                        thirdDozenHash.put(number, thirdDozenBetAmount);
                    }
                    isthirdCozen = true;
                    if (isContinue()) {
                        continue;
                    }
                    break;
                case 13 :
                    if(betHash.isEmpty()){
                        System.out.println("Please enter your bet first");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Please enter a valid value");

            }

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

            double amountWon = 0;
            double firstBet = 0;
            double secondBet= 0;
            double thirdBet= 0;
            double fourthBet= 0;
            double fifthBet= 0;
            double sixthBet= 0;
            double seventhBet= 0;
            double eighthBet= 0;
            double ninthBet= 0;
            double tenthBet= 0;
            double eleventhBet= 0;

            if (betHash.containsKey(result) || redHash.containsKey(result) || blackHash.containsKey(result) ||evenHash.containsKey(result) ||oddHash.containsKey(result) ||
                    firstColumnHash.containsKey(result) ||secondColumnHash.containsKey(result) ||thirdColumnHash.containsKey(result) ||
                    firstDozenHash.containsKey(result) || secondDozenHash.containsKey(result) ||thirdDozenHash.containsKey(result)){
                if(multiplierNumber == result && betHash.containsKey(multiplierNumber)){
                    firstBet = betHash.get(result) * multiplier;

                    if(redHash.containsKey(result)) {
                        secondBet = redHash.get(result) * 36;
                    }
                    if(blackHash.containsKey(result)) {
                        thirdBet     = blackHash.get(result) * 36;
                    }
                    if(evenHash.containsKey(result)) {
                        fourthBet    = evenHash.get(result) * 36;
                    }
                    if(oddHash.containsKey(result)) {
                        fifthBet     = oddHash.get(result) * 36;
                    }
                    if(firstColumnHash.containsKey(result)) {
                        sixthBet     = firstColumnHash.get(result) * 36;
                    }
                    if(secondColumnHash.containsKey(result)) {
                        seventhBet   = secondColumnHash.get(result) * 36;
                    }
                    if(thirdColumnHash.containsKey(result)) {
                        eighthBet    = thirdColumnHash.get(result) * 36;
                    }
                    if(firstDozenHash.containsKey(result)) {
                        ninthBet     = firstDozenHash.get(result) * 36;
                    }
                    if(secondDozenHash.containsKey(result)) {
                        tenthBet     = secondDozenHash.get(result) * 36;
                    }
                    if(thirdDozenHash.containsKey(result)) {
                        eleventhBet  = thirdDozenHash.get(result) * 36;
                    }
                    amountWon = (firstBet + secondBet + thirdBet + fourthBet+ fifthBet +sixthBet + seventhBet + eighthBet+ninthBet + tenthBet+ eleventhBet);


                    
                }else {
                    if(betHash.containsKey(result)) {
                        firstBet = betHash.get(result) * 36;
                    }
                    if(redHash.containsKey(result)) {
                        secondBet = redHash.get(result) * 36;
                    }
                    if(blackHash.containsKey(result)) {
                        thirdBet     = blackHash.get(result) * 36;
                    }
                    if(evenHash.containsKey(result)) {
                        fourthBet    = evenHash.get(result) * 36;
                    }
                    if(oddHash.containsKey(result)) {
                        fifthBet     = oddHash.get(result) * 36;
                    }
                    if(firstColumnHash.containsKey(result)) {
                        sixthBet     = firstColumnHash.get(result) * 36;
                    }
                    if(secondColumnHash.containsKey(result)) {
                        seventhBet   = secondColumnHash.get(result) * 36;
                    }
                    if(thirdColumnHash.containsKey(result)) {
                        eighthBet    = thirdColumnHash.get(result) * 36;
                    }
                    if(firstDozenHash.containsKey(result)) {
                        ninthBet     = firstDozenHash.get(result) * 36;
                    }
                    if(secondDozenHash.containsKey(result)) {
                        tenthBet     = secondDozenHash.get(result) * 36;
                    }
                    if(thirdDozenHash.containsKey(result)) {
                        eleventhBet  = thirdDozenHash.get(result) * 36;
                    }
                    amountWon = (firstBet + secondBet + thirdBet + fourthBet+ fifthBet +sixthBet + seventhBet + eighthBet+ninthBet + tenthBet+ eleventhBet);

                }



            }else {
                System.out.println("You have been lost !");
            }
            break;

        }while (true) ;



    }
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(37);
    }
    public static int generateRandomMultiplierNumber() {
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

    public static int generateMultiplier(Random random) {
        // 75% chance to return 1
        if (random.nextDouble() < 0.50) {
            return 36;
        }
        // 25% chance to return a random integer between 2 and 250
        else {
            return 37 + random.nextInt(249); // nextInt(249) generates a number between 0 and 248, add 2 to make it between 2 and 250
        }
    }
}
