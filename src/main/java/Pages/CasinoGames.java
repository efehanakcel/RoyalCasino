package Pages;

import java.util.Scanner;
import Games.ImmersiveRoulette;
import Games.LightningRoulette;
import Games.DoubleBallRoulette;
import Account.Account;
public class CasinoGames {

    public static void getGames(Account loggedInAccount){
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Press 1 to Play Immersive Roulette");
            System.out.println("Press 2 to Play Lightning Roulette");
            System.out.println("Press 3 to Play Double Ball Roulette");

            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                  ImmersiveRoulette.play(loggedInAccount);
                  break;
                case 2:
                    LightningRoulette.play();
                case 3:
                    DoubleBallRoulette.play();
                default:
                    System.out.println("Please enter a valid number");



            }
            break;





        }







    }












}
