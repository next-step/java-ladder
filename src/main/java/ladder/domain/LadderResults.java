package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {

    private List<String> results;

    public LadderResults(List<String> results) {
        this.results = results;
    }

    public String get(int pos) {
        return results.get(pos);
    }

    @Override
    public String toString() {
        return results.stream()
                .map(result -> String.format("%1$7s", result))
                .collect(Collectors.joining());
    }

}
