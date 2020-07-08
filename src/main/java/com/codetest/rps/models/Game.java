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
        if (playerChoice == Choices.PAPER)
            return Results.WIN;
        else
            return Results.LOSE;
    }

    public Choices getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice (Choices choice) { playerChoice = choice; }

    public Choices getComputerChoice() { return computerChoice; }

    public Results getResult() { return result; }
}
