package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final String[] results;

    public Results(String[] results) {
        this.results = results;
    }

    public String get(final Position endPosition) {
        return this.results[endPosition.get()];
    }

    @Override
    public String toString() {
        final List<String> collect = Arrays.stream(this.results)
                .map(r -> String.format("%-6s", r))
                .collect(Collectors.toList());

        return String.join("", collect);
    }

}
