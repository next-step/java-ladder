package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderResults {
    private List<String> results;

    public LadderResults(List<String> results) {
        this.results = results;
    }

    public String getResult(int i) {
        return results.get(i);
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(results);
    }
}
