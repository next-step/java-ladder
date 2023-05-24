package ladder.domain;

import java.util.Collections;
import java.util.List;

public class GameResult {
    private List<String> gameResults;

    private GameResult(List<String> gameResults) {
        validateGameResult(gameResults);
        this.gameResults = gameResults;
    }

    private void validateGameResult(List<String> gameResults) {
        if (isEmpty(gameResults)) {
            throw new IllegalArgumentException("GameResult is Empty");
        }
    }

    private boolean isEmpty(List<String> gameResults) {
        return gameResults == null || gameResults.isEmpty();
    }

    public static GameResult create(List<String> gameResults) {
        return new GameResult(gameResults);
    }

    public List<String> gameResult() {
        return Collections.unmodifiableList(gameResults);
    }

    public int size() {
        return this.gameResults.size();
    }

    public String getResultByIndex(int index) {
        return this.gameResults.get(index);
    }
}
