package snakeandladdergame;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static GameManager instance;
    private final List<SnakeAndLadderGame> games;

    private GameManager() {
        games = new ArrayList<>();
    }

    public static synchronized GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void startNewGame(List<String> playerNames) {
        SnakeAndLadderGame game = new SnakeAndLadderGame(playerNames);
        games.add(game); // add one game
        new Thread(() -> game.play()).start(); //play game 1  by 1
    }
}
