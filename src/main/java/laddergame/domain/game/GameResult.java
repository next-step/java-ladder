package laddergame.domain.game;

import java.util.Map;
import java.util.Set;

public class GameResult {
    private final Map<String, Prize> winningResults;

    public GameResult(final Map<String, Prize> winningResults) {
        this.winningResults = winningResults;
    }

    public Prize findByName(final String name) {
        validateFindName(name);
        return winningResults.get(name);
    }

    public Set<Map.Entry<String, Prize>> findAll() {
        return winningResults.entrySet();
    }

    private void validateFindName(final String name) {
        if (!winningResults.containsKey(name)) {
            throw new IllegalArgumentException("존재하지않는 이름입니다. - " + name);
        }
    }
}
