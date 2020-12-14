package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {

    private List<LadderResult> results;

    public LadderResults(List<String> results) {
        this.results = results.stream()
                .map(LadderResult::new)
                .collect(Collectors.toList());
    }

    public LadderResult get(int pos) {
        return results.get(pos);
    }

    @Override
    public String toString() {
        return results.stream()
                .map(result -> String.format("%1$7s", result))
                .collect(Collectors.joining());
    }

}
