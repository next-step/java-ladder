package ladder.dto;

import java.util.List;

public class GameResults {
    private final List<GameResult> gameResults;

    public GameResults(List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public List<GameResult> getGameResults() {
        return gameResults;
    }

    public String getResult(String name) {
        return gameResults.stream()
                .filter(result -> result.getPlayer().isEqualName(name))
                .map(result -> result.getPrize())
                .findFirst()
                .orElseGet(null);
    }

}
