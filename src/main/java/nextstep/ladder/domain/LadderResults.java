package nextstep.ladder.domain;

import java.util.*;

public class LadderResults {
    private final Map<String, String> resultMap;

    public LadderResults(final Map<String, String> resultMap) {
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
        LadderResults that = (LadderResults) o;
        return Objects.equals(resultMap, that.resultMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultMap);
    }

}
