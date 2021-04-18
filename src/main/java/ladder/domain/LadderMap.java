package ladder.domain;

import java.util.Map;

public class LadderMap {
    private final Map<Integer, Integer> radderResultMap;

    public LadderMap(Map<Integer, Integer> radderResultMap) {
        this.radderResultMap = radderResultMap;
    }

    public Integer getArrivalIndex(int startIndex) {
        return radderResultMap.get(startIndex);
    }
}
