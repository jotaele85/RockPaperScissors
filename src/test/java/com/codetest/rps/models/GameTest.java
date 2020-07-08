package com.codetest.rps.models;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    Game game;

    @Test
    public void playerShouldWinTheGame() {
        //Prepare the test
        game = new Game();
        game.setPlayerChoice(Choices.PAPER);

        Results result = game.obtainResult();

        Assert.assertEquals(Results.WIN, result);
    }

    @Test
    public void playerShouldLoseTheGame() {
        //Prepare the test
        game = new Game();
        game.setPlayerChoice(Choices.SCISSORS);

        Results result = game.obtainResult();

        Assert.assertEquals(Results.LOSE, result);
    }

    @Test
    public void playerShouldTieTheGame() {
        //Prepare the test
        game = new Game();
        game.setPlayerChoice(Choices.ROCK);

        Results result = game.obtainResult();

        Assert.assertEquals(Results.DRAW, result);
    }

    @Test
    public void computerAlwaysChooseRock() {
        game = new Game();
        game.play();

        Assert.assertEquals(Choices.ROCK, game.getComputerChoice());
    }
}
