package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameResults {
    private final List<LadderGameResult> results;

    public LadderGameResults(List<LadderGameResult> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return this.results.stream()
                .map(LadderGameResult::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
