package com.codetest.rps.services;

import com.codetest.rps.models.Game;
import com.codetest.rps.components.GameComponent;
import com.codetest.rps.models.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class GameService {

    private GameComponent gameComponent;

    private AtomicInteger computerWinsAcc;
    private AtomicInteger playerWinsAcc;
    private AtomicInteger gamesAcc;
    private AtomicInteger drawsAcc;

    /**
     * Parameterized constructor for {@linc GameService}. It initializes the accumulators as 0.
     * @param gameComponent - the {@linc GameComponent} to set.
     */
    @Autowired
    public GameService(GameComponent gameComponent) {
        this.gameComponent = gameComponent;
        computerWinsAcc = new AtomicInteger(0);
        playerWinsAcc = new AtomicInteger(0);
        gamesAcc = new AtomicInteger(0);
        drawsAcc = new AtomicInteger(0);
    }

    /**
     * This function adds a new game in the list of games. It also increases the accumulators as needed.
     * @return the {@Link List<Game>} with the list of games.
     */
    public List<Game> playGame() {
        Game game = createGame();
        Results result = game.play();
        gameComponent.addGame(game);

        gamesAcc.incrementAndGet();
        if (Results.WIN.equals(result))
            playerWinsAcc.incrementAndGet();
        if (Results.LOSE.equals(result))
            computerWinsAcc.incrementAndGet();
        if (Results.DRAW.equals(result))
            drawsAcc.incrementAndGet();

        return gameComponent.getGames();
    }

    /**
     * Clear the list of games.
     */
    public void restartGame() {
        gameComponent.restart();
    }

    /**
     * Returns the number of games win by the computer.
     * @return the {@Link int} with the result.
     */
    public int getComputerWinsAcc() {
        return computerWinsAcc.get();
    }

    /**
     * Returns the number of games win by the player.
     * @return the {@Link int} with the result.
     */
    public int getPlayerWinsAcc() {
        return playerWinsAcc.get();
    }

    /**
     * Returns the total number of games played.
     * @return the {@Link int} with the result.
     */
    public int getGamesAcc() {
        return gamesAcc.get();
    }

    /**
     * Returns the number of draw games.
     * @return the {@Link int} with the result.
     */
    public int getDrawsAcc() { return drawsAcc.get(); }

    /**
     * Return new Game. This method is created to allow the test of the class.
     * @return the {@Link Game} created.
     */
    protected Game createGame() {
        return new Game();
    }
}
