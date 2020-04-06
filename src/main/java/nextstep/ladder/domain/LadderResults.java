package nextstep.ladder.domain;

import java.util.List;

public class LadderResults {

    private final List<String> results;

    public LadderResults(List<String> results) {
        this.results = results;
    }

    public int getSize() {
        return results.size();
    }
}
