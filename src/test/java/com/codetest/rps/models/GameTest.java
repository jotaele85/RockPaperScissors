package com.codetest.rps.models;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    Game game;

    @Test
    public void playerShouldWinTheGame(){
        //Prepare the test
        game = new Game();
        game.setPlayerChoice(Choices.PAPER);

        game.play();

        Assert.assertEquals(Results.WIN, game.getResult());
    }

}
