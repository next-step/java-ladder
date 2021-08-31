package nextstep.ladder.domain;

import java.util.*;

public class LadderResults {
    private final Map<Player, String> resultMap;

    public LadderResults(Map<Player, String> resultMap) {
        this.resultMap = resultMap;
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
