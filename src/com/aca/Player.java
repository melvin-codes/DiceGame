package com.aca;

public class Player {
    public String name;
    public int [] dieSet;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDieSet(int[] ints) {
        this.dieSet = RollDie.DiceSet();
    }
    public int [] getDieSet() {
        return dieSet;
    }

    @Override
    public String toString() {
        return "[" + dieSet[0] + ", " + dieSet[1] + ", " + dieSet[2] + "]";
    }
}
