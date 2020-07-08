package com.codetest.rps.services;

import com.codetest.rps.components.GameComponent;
import com.codetest.rps.models.Game;
import com.codetest.rps.models.Results;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    @InjectMocks
    GameService gameService;

    @Mock
    GameComponent gameComponent;

    @Mock
    Game game;

    @Test
    public void shouldPlayGameAndIncreaseGamesAcc() {
        gameService.playGame();

        Assert.assertEquals(1, gameService.getGamesAcc());
    }

    @Test
    public void shouldPlayAndIncreasePlayerWinsAcc() {
        //Preparing the test
        Mockito.when(game.play()).thenReturn(Results.WIN);
        GameService gameServiceAux = Mockito.spy(gameService);
        Mockito.when(gameServiceAux.createGame()).thenReturn(game);

        gameServiceAux.playGame();

        Assert.assertEquals(1, gameService.getGamesAcc());
        Assert.assertEquals(1, gameService.getPlayerWinsAcc());
        Assert.assertEquals(0, gameService.getComputerWinsAcc());
        Assert.assertEquals(0, gameService.getDrawsAcc());
    }

    @Test
    public void shouldPlayAndIncreaseComputerWinsAcc() {
        //Preparing the test
        Mockito.when(game.play()).thenReturn(Results.LOSE);
        GameService gameServiceAux = Mockito.spy(gameService);
        Mockito.when(gameServiceAux.createGame()).thenReturn(game);

        gameServiceAux.playGame();

        Assert.assertEquals(1, gameService.getGamesAcc());
        Assert.assertEquals(0, gameService.getPlayerWinsAcc());
        Assert.assertEquals(1, gameService.getComputerWinsAcc());
        Assert.assertEquals(0, gameService.getDrawsAcc());
    }

    @Test
    public void shouldPlayAndIncreaseDrawsAcc() {
        //Preparing the test
        Mockito.when(game.play()).thenReturn(Results.DRAW);
        GameService gameServiceAux = Mockito.spy(gameService);
        Mockito.when(gameServiceAux.createGame()).thenReturn(game);

        gameServiceAux.playGame();

        Assert.assertEquals(1, gameService.getGamesAcc());
        Assert.assertEquals(0, gameService.getPlayerWinsAcc());
        Assert.assertEquals(0, gameService.getComputerWinsAcc());
        Assert.assertEquals(1, gameService.getDrawsAcc());
    }
}
