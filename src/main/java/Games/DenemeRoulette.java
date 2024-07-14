package Games;

import Account.Account;

import java.util.*;

public class DenemeRoulette {

    public static void play(Account loggedInAccount) {
        List<Integer> redNumbers = new ArrayList<>(18);
        List<Integer> blackNumbers = new ArrayList<>(18);
        List<Integer> oddNumbers = new ArrayList<>(18);
        List<Integer> evenNumbers = new ArrayList<>(18);
        List<Integer> firstColumn = new ArrayList<>(18);
        List<Integer> secondColumn = new ArrayList<>(18);
        List<Integer> thirdColumn = new ArrayList<>(18);
        List<Integer> firstDozen = new ArrayList<>(18);
        List<Integer> secondDozen = new ArrayList<>(18);
        List<Integer> thirdDozen = new ArrayList<>(18);
        int green = 0;
        for (int i = 1; i < 37; i++) {
            if(i <13){
                firstDozen.add(i);
            } else if (i <= 24) {
                secondDozen.add(i);
            }else {
                thirdDozen.add(i);
            }
            if(i%3 == 1){
                firstColumn.add(i);
            } else if (i % 3 == 2) {
                secondColumn.add(i);
            }else {
                thirdColumn.add(i);
            }
            if (i%2==0){
                redNumbers.add(i);
                evenNumbers.add(i);
            }else {
                blackNumbers.add(i);
                oddNumbers.add(i);
            }
        }
        do {
            Scanner scanner = new Scanner(System.in);


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
            HashMap<Integer, Integer> betHash = new HashMap<>();
            switch (betType) {
                case 1:
                    while (true){
                        System.out.println("Please enter the number");
                        int betNumber =  scanner.nextInt();
                        System.out.println("Please enter the amount");
                        int betAmount = scanner.nextInt();
                        betHash.put(betNumber, betAmount);
                        System.out.println("Would you like to continue to bet ? \n" +
                                "Enter Yes to continue, No for Bet List ");
                        String devamMi = scanner.nextLine();
                        devamMi.toLowerCase();
                        if (devamMi.equals("yes")){
                            continue;
                        }
                        break;
                    }
                    for (Integer i : betHash.keySet()) {


                    }

                case 2:
                case 3:

                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
            }







        }while (true);









    }
}
