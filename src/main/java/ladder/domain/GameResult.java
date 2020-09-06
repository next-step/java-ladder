package ladder.domain;

import java.util.Map;
import java.util.Objects;

public class GameResult {
    private final Map<String, String> gameResults;

    private GameResult(Map<String, String> gameResults) {
        this.gameResults = gameResults;
    }

    public static GameResult of(Map<String, String> gameResults) {
        return new GameResult(gameResults);
    }

    public boolean hasResult(String player) {
        return gameResults.keySet().contains(player);
    }

    public String getResult(String playerName) {
        return gameResults.get(playerName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(gameResults, that.gameResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameResults);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        gameResults.keySet().stream()
                .forEach(playerName -> stringBuilder.append(playerName + " : " + gameResults.get(playerName) + "\n"));
        return stringBuilder.toString();
    }
}
