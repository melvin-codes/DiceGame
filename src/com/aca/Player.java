package com.aca;

public class Player {
    private String name;
    private int [] dieSet;
    private int total;
    private int winner;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDieSet(int[] ints) {
        this.dieSet = RollDie.DiceSetCreator();
    }
    public int [] getDieSet() {
        return dieSet;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public int getWinner() {
        return winner;
    }
    public void setWinner(int winner) {
        this.winner = winner;
    }
    @Override
    public String toString() {
        return "[" + dieSet[0] + ", " + dieSet[1] + ", " + dieSet[2] + "]";
    }
}
