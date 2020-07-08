package com.codetest.rps.services;

import com.codetest.rps.components.GameComponent;
import com.codetest.rps.models.Choices;
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

    @Test
    public void shouldPlayGameAndIncreaseGamesAcc() {
        gameService.playGame();

        Assert.assertEquals(1, gameService.getGamesAcc());
    }
}
