package com.codetest.rps.components;

import com.codetest.rps.models.Game;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class GameComponent {

    private List<Game> gameList;

    public GameComponent() {
        gameList = new ArrayList<Game>();
    }

    /**
     * Clear the list of games.
     */
    public void restart() {
        gameList.clear();
    }

    /**
     * Returns the list of games.
     * @return the {@Link List<Game>}
     */
    public List<Game> getGames() {
        return gameList;
    }

    /**
     * Include the game in the list.
     * @param {@Link Game} with the game to add.
     */
    public void addGame(Game game) {
        gameList.add(game);
    }
}