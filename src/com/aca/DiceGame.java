package com.aca;

import java.util.Scanner;
public class DiceGame {

    public static int dieSetTotal(int [] dieSet) {
        int total = 0;
        for(int num: dieSet) {
            total += num;
        }
        return total;
    }
    public static void roundChecker(int P1total, int P2total, Player P1, Player P2) {
        int winner = 0;
        if(P1total > P2total) {
            winner = 1;
        }
        else if(P2total > P1total) {
             winner = 2;
        }
        //Declares the winner using 0,1,2 as well as the switch
        switch(winner) {
            case 1:
                System.out.println(P1.getName() + " is Victorious!\n");
                break;
            case 2:
                System.out.println(P2.getName() + " is Victorious!\n");
                break;
            case 0:
                System.out.println("This round was a tie");
                System.out.println("There will be a re-roll!");
                P1.setDieSet(RollDie.DiceSet());
                P2.setDieSet(RollDie.DiceSet());
                P1total = RollDie.dieSetTotal(P1.getDieSet());
                P2total = RollDie.dieSetTotal(P2.getDieSet());
                System.out.println(P1.getName() + "'s rolls: " + P1 + ", Total: " + P1total);
                System.out.println(P2.getName() + "'s rolls: " + P2 + ", Total: " + P2total);
                System.out.println();
                roundChecker(P1total, P2total, P1, P2);
                break;
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the game of dice!");
        System.out.println("Please input you and your friends name. (Hit enter after each name)");

        //Sets the players name
        Player P1 = new Player();
        P1.setName(sc.nextLine());
        Player P2 = new Player();
        P2.setName(sc.nextLine());

        System.out.println("This game consists of 5 rounds\n");
        int rounds = 1;
        while(rounds != 6) {
            //Sets the 3 rolled die and then adds them
            P1.setDieSet(RollDie.DiceSet());
            P2.setDieSet(RollDie.DiceSet());
            int P1total = RollDie.dieSetTotal(P1.getDieSet());
            int P2total = RollDie.dieSetTotal(P2.getDieSet());

            //Prints out the rounds die rolls and totals
            System.out.println("Round " + rounds + ":");
            System.out.println(P1.getName() + "'s rolls: " + P1 + ", Total: " + P1total);
            System.out.println(P2.getName() + "'s rolls: " + P2 + ", Total: " + P2total);
            System.out.println();

            //Declares who is the winner
            roundChecker(P1total, P2total, P1, P2);

            rounds++;
        }
    }

}
