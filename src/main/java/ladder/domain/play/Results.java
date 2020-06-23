package ladder.domain.play;

import java.util.List;

public class Results {
    private final Items results;

    private Results(List<String> results) {
        this.results = Items.of(results);
    }

    public static Results of(List<String> results) {
        return new Results(results);
    }

    @Override
    public String toString() {
        return results.toString();
    }
}
