package ladder.model;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class LadderResults {
    private final List<LadderResult> results;

    LadderResults(List<String> results) {
        this.results = results.stream()
                .map(LadderResult::of)
                .collect(toList());
    }

    List<String> getResults() {
        return results.stream()
                .map(LadderResult::getResult)
                .collect(toList());
    }
}
