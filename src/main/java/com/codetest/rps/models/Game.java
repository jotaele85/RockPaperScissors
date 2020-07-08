package com.codetest.rps.models;

public class Game {

    private Choices playerChoice;
    private Choices computerChoice;
    private Results result;

    public Game() {
    }

    /**
     * This method play a new round of a game and calculates the result.
     */
    public Results play() {
        //First step: generation of random choice for the player
        playerChoice = Choices.getRandomChoice();

        //Second step: Computer choice is always ROCK
        computerChoice = Choices.ROCK;

        //Third step: Obtain the result
        result = obtainResult();
        return result;
    }

    /**
     * Return the Result of a game.
     * @return {@Link Result} with the result.
     */
    public Results obtainResult() {
        if (Choices.PAPER.equals(playerChoice))
            return Results.WIN;
        else if (Choices.SCISSORS.equals(playerChoice))
            return Results.LOSE;
        else
            return Results.DRAW;
    }

    public Choices getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice (Choices choice) { playerChoice = choice; }

    public Choices getComputerChoice() { return computerChoice; }

    public Results getResult() { return result; }
}
