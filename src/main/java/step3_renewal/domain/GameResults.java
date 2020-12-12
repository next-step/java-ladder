package step3_renewal.domain;

import java.util.Collections;
import java.util.List;

public class GameResults {

    private List<GameResult> gameResults;

    private GameResults(final List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public static GameResults of(final List<GameResult> gameResults) {
        return new GameResults(gameResults);
    }

    public List<GameResult> getGameResults() {
        return Collections.unmodifiableList(gameResults);
    }
}
