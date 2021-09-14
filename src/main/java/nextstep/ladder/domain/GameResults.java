package nextstep.ladder.domain;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class GameResults {
    private final Map<String, String> resultMap;

    public GameResults(final Map<String, String> resultMap) {
        this.resultMap = resultMap;
    }

    public Set<String> getPlayers() {
        return resultMap.keySet();
    }

    public String findResultByPlayer(String player) {
        return resultMap.get(player);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResults that = (GameResults) o;
        return Objects.equals(resultMap, that.resultMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultMap);
    }
}
