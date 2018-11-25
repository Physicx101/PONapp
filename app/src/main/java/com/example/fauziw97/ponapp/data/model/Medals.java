package com.example.fauziw97.ponapp.data.model;

public class Medals {
    private int rank;
    private String contingent;
    private int gold;
    private int silver;
    private int bronze;
    private int total;

    public Medals() {

    }

    public String getContingent() {
        return contingent;
    }

    public void setContingent(String contingent) {
        this.contingent = contingent;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getBronze() {
        return bronze;
    }

    public void setBronze(int bronze) {
        this.bronze = bronze;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
