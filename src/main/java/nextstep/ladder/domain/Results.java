package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private final List<String> results;

    public Results(List<String> participants) {
        this.results = participants;
    }

    public List<String> getResults() {
        return new ArrayList<>(results);
    }
}
