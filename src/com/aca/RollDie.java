package com.aca;

import java.util.Random;

public class RollDie {
    public static int rollDie() {
        Random random = new Random();
        return (int)(Math.random() * 6 + 1);
    }
    public static int [] DiceSet() {
        int[] DiceSet = new int[3];
        for(int i = 0; i < 3; i++) {
            DiceSet[i] = rollDie();
        }
        return DiceSet;
    }
    public static int dieSetTotal(int [] dieSet) {
        int total = 0;
        for(int num: dieSet) {
            total += num;
        }
        return total;
    }
}
