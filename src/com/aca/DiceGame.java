package com.aca;

import java.util.Scanner;
public class DiceGame {

    public static String winChecker(Player P1, Player P2) {
        if(P1.getTotal() > P2.getTotal()) {
            P1.setWinner(1);
            return P1.getName() + " is Victorious!\n";
        }
        else if(P2.getTotal() > P1.getTotal()) {
            P2.setWinner(2);
            return P2.getName() + " is Victorious!\n";
        }
        else if(P1.getTotal() == P2.getTotal()) {
            P1.setWinner(0);
            P2.setWinner(0);
            return "That round was a tie!, there will be a re-roll\n";
        }
        return null;
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

        System.out.println("This game consists of 5 round\n");
        int round = 1;
        while(round != 30) {
            //Sets the rolled die
            P1.setDieSet(RollDie.DiceSetCreator());
            P2.setDieSet(RollDie.DiceSetCreator());
            //Adds the rolled dice
            P1.setTotal(RollDie.dieSetTotal(P1.getDieSet()));
            P2.setTotal(RollDie.dieSetTotal(P2.getDieSet()));

            //Prints out the round die rolls and totals
            System.out.println("Round " + round + ":");
            System.out.println(P1.getName() + "'s rolls: " + P1 + ", Total: " + P1.getTotal());
            System.out.println(P2.getName() + "'s rolls: " + P2 + ", Total: " + P2.getTotal());
            System.out.println();

            //Declares who is the winner
            winChecker(P1,P2);
            if(P1.getWinner() != P2.getWinner()) {
                System.out.println(winChecker(P1,P2));
            }
            else {
                System.out.println(winChecker(P1,P2));
                while(P1.getWinner() == P2.getWinner()) {
                    P1.setDieSet(RollDie.DiceSetCreator());
                    P2.setDieSet(RollDie.DiceSetCreator());
                    P1.setTotal(RollDie.dieSetTotal(P1.getDieSet()));
                    P2.setTotal(RollDie.dieSetTotal(P2.getDieSet()));
                    winChecker(P1,P2);
                    System.out.println("Re-roll:");
                    System.out.println(P1.getName() + "'s rolls: " + P1 + ", Total: " + P1.getTotal());
                    System.out.println(P2.getName() + "'s rolls: " + P2 + ", Total: " + P2.getTotal());
                    System.out.println();
                    System.out.println(winChecker(P1,P2));
                }

            }
            if(round != 5) {
                System.out.println();
                System.out.println("[ Hit enter for the next round ]");
                String enter = sc.nextLine();
                if(enter.equals("")) {
                    round++;
                }
            }
            else {
                round++;
            }
        }
    }

}
