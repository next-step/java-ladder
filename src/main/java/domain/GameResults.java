package domain;

import common.CommonConstants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class GameResults {
    private final List<String> gameResults;

    private GameResults(final List<String> gameResults) {
        this.gameResults = gameResults;
    }

    public static GameResults of(final String results) {
        List<String> gameResults = Arrays.asList(results.split(CommonConstants.SPLIT_DELIMITER_COMMA));
        return new GameResults(gameResults);
    }

    public Stream<String> stream() {
        return gameResults.stream();
    }

    public String get(int index) {
        return gameResults.get(index);
    }
}
