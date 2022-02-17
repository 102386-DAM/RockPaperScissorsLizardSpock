package com.udl.tidic.rockpaperscissorslizardspock.models;

import java.util.Random;

public enum Options {
    ROCK,
    PAPER,
    SCISSORS,
    LIZARD,
    SPOCK;

    public static Options getRandomDecision() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
