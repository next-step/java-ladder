package game.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class GameResults {

    private final List<GameResult> gameResults;

    public GameResults(List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public String getStringGameResults() {
        return gameResults.stream().map(GameResult::getStringResult).collect(Collectors.joining(System.lineSeparator()))+System.lineSeparator();
    }

    public int size() {
        return this.gameResults.size();
    }
}
