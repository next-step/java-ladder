package ladder.domain;

import java.util.List;

public class LadderResult {
    private final List<Integer> results;

    public LadderResult(List<Integer> results) {
        this.results = results;
    }

    public int get(int index) {
        return results.get(index);
    }
}
