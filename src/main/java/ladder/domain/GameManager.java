package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameManager {

    private final List<GameResult> gameResults;

    private GameManager(List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public static GameManager of(List<GameResult> gameResults) {
        return new GameManager(gameResults);
    }

    public List<GameResult> getResult(String resultKey) {
        String defaultKey = "all";

        if (defaultKey.equals(resultKey)) {
            return gameResults;
        }
        return selectResult(resultKey);
    }

    private List<GameResult> selectResult(String resultKey) {
        return gameResults.stream()
                .filter(e -> e.contains(resultKey))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameManager that = (GameManager) o;
        return Objects.equals(gameResults, that.gameResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameResults);
    }
}
