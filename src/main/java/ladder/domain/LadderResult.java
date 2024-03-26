package ladder.domain;

import java.util.Map;

public class LadderResult {

    private final Map<Integer, Integer> resultIndices;

    public LadderResult(Map<Integer, Integer> resultIndices) {
        this.resultIndices = resultIndices;
    }

    public Integer resultIndexOf(int index) {
        return resultIndices.get(index);
    }
}
