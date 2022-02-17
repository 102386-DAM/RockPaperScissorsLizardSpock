package com.udl.tidic.rockpaperscissorslizardspock.models;

public class Player {
    private String name;
    private Options decision;
    private int winners;
    private int derrotes;

    public Player() {

    }

    public Player(String name, Options decision) {
        this.name = name;
        this.decision = decision;
        this.winners = 0;
        this.derrotes = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Options getDecision() {
        return decision;
    }

    public void setDecision(Options decision) {
        this.decision = decision;
    }

    public int getWinners() {
        return winners;
    }

    public void setWinners(int winners) {
        this.winners = winners;
    }

    public int getDerrotes() {
        return derrotes;
    }

    public void setDerrotes(int derrotes) {
        this.derrotes = derrotes;
    }
}
