package ladder.domain;

import java.util.Map;

public class GameResult {
    Map<Person, Result> gameResult;

    private GameResult(Map<Person, Result> gameResult) {
        this.gameResult = gameResult;
    }

    public static GameResult valueOf(Map<Person, Result> gameResult) {
        return new GameResult(gameResult);
    }
}
