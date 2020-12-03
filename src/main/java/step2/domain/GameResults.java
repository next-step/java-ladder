package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GameResults {
    private final List<GameResult> gameResults;

    private GameResults(final List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public static GameResults of(final List<GameResult> gameResults) {
        return new GameResults(gameResults);
    }

    public List<GameResult> getGameResults() {
        return Collections.unmodifiableList(gameResults);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResults that = (GameResults) o;
        return Objects.equals(gameResults, that.gameResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameResults);
    }
}
