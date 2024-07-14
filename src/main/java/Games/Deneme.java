package Games;

import java.util.*;

public class Deneme {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> redNumbers = new ArrayList<>(18);
        HashMap<Integer, Integer> betHash = new HashMap<>();

        for (int i = 1; i < 37; i++) {
            if (i % 2 == 0) {
                redNumbers.add(i);
            }
        }




        while (true) {
            int betType = scanner.nextInt();
            switch (betType) {
                case 1:
                    while (true) {
                        System.out.println("Please enter the number");
                        int betNumber = scanner.nextInt();
                        System.out.println("Please enter the amount");
                        int betAmount = scanner.nextInt();
                        betHash.put(betNumber, betAmount);
                        scanner.nextLine();
                        if (isContinue()) {
                            continue;
                        }
                        break;

                    }


                case 2:
                    System.out.println("Please enter the amount");
                    int betAmount = scanner.nextInt();
                    betHash.put(0, betAmount);
                    break;

                case 3:
                    System.out.println("Please enter the amount");
                    int redBetAmount = scanner.nextInt();

                    for (Integer number : redNumbers) {
                        if(betHash.containsKey(number)){
                            betHash.put(number, redBetAmount / 18 + betHash.get(number));
                        }else {
                            betHash.put(number,redBetAmount / 18 );
                        }
                        betHash.put(number, redBetAmount / 18 + currentAmount);
                        for (Integer i : betHash.keySet()) {
                            System.out.println(i);
                        }
                    }
            }
            if (isContinue()) {
                continue;
            }
            break;
        }
    }


    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(37);


    }

    public static boolean isContinue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to continue to bet ? \n" +
                "Enter Yes to continue, No for Bet List ");
        String devamMi = scanner.nextLine();
        devamMi.toLowerCase();
        if (devamMi.equals("yes")) {
            return true;
        }
        return false;
    }
}

