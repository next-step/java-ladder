package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameManager {

    private static final String DEFAULT_KEY = "all";
    private final GameResults gameResults;

    private GameManager(GameResults gameResults) {
        this.gameResults = gameResults;
    }

    public static GameManager of(GameResults gameResults) {
        return new GameManager(gameResults);
    }

    public List<GameResult> getResult(String resultKey) {
        if (DEFAULT_KEY.equals(resultKey)) {
            return gameResults.getGameResults();
        }
        return selectResult(resultKey);
    }

    private List<GameResult> selectResult(String userName) {
        return gameResults.getGameResults().stream()
                .filter(gameResult -> gameResult.contains(userName))
                .collect(Collectors.toList());
    }

    public static String getDefaultKey() {
        return DEFAULT_KEY;
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
