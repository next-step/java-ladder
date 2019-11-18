package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderGameResults {

    private final List<String> results;

    public LadderGameResults(List<String> results) {
        this.results = results;
    }

    public List<String> getValue() {
        return Collections.unmodifiableList(results);
    }
}
