package com.codetest.rps.models;

import java.util.Random;

public enum Choices {
    ROCK,
    PAPER,
    SCISSORS;

    private static final Choices[] VALUES = values();

    /**
     * Returns a random Choice.
     * @return the {@Link Choice} with the random value.
     */
    public static Choices getRandomChoice()  {
        return VALUES[new Random().nextInt(values().length)];
    }
}
