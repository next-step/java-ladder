package domain;

import common.CommonConstants;

import java.util.Arrays;
import java.util.List;

public class GameResults {
    private final List<String> gameResults;

    private GameResults(final List<String> gameResults) {
        this.gameResults = gameResults;
    }

    public static GameResults of(final String results) {
        List<String> gameResults = Arrays.asList(results.split(CommonConstants.SPLIT_DELIMITER_COMMA));
        return new GameResults(gameResults);
    }

    public List<String> getGameResults() {
        return gameResults;
    }

    public String get(int index) {
        return gameResults.get(index);
    }
}
