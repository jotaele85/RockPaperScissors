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
    public void play() {
        //First step: generation of random choice for the player
        playerChoice = Choices.getRandomChoice();

        //Second step: Computer choice is always ROCK
        computerChoice = Choices.ROCK;

        //Third step: Obtain the result
        this.result = obtainResult();
    }

    /**
     * Return the Result of a game.
     * @return {@Link Result} with the result.
     */
    private Results obtainResult() {
        if (Choices.PAPER.equals(playerChoice))
            return Results.WIN;
        else if (Choices.SCISSORS.equals(playerChoice))
            return Results.LOSE;
        return Results.DRAW;
    }

    public Choices getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice (Choices choice) { playerChoice = choice; }

    public Choices getComputerChoice() { return computerChoice; }

    public Results getResult() { return result; }
}
