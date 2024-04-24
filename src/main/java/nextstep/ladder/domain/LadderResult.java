package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {

    private List<String> results;

    public LadderResult(List<String> results) {
        this.results = results;
    }

    public String asString() {
        return results.stream()
                .collect(Collectors.joining("   ", " ", ""));
    }

    public String get(Integer i) {
        return results.get(i);
    }
}
