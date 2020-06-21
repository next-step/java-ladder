package laddergame.domain.game;

import java.util.Map;
import java.util.Set;

public class GameResult {
    private final Map<String, Result> winningResults;

    public GameResult(final Map<String, Result> winningResults) {
        this.winningResults = winningResults;
    }

    public Result findByName(final String name) {
        validateFindName(name);
        return winningResults.get(name);
    }

    public Set<Map.Entry<String, Result>> findAll() {
        return winningResults.entrySet();
    }

    private void validateFindName(final String name) {
        if (!winningResults.containsKey(name)) {
            throw new IllegalArgumentException("존재하지않는 이름입니다. - " + name);
        }
    }
}
