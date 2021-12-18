package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Results extends FirstClassList<Result> {
    private Results(final List<Result> results) {
        super(results);
    }

    public static Results fromString(final List<String> results) {
        if (results == null) {
            throw new IllegalArgumentException("invalid results: cannot be null or empty");
        }

        return of(results.stream()
                .map(Result::of)
                .collect(Collectors.toList()));
    }
    public static Results of(final List<Result> results) {
        if (results == null || results.isEmpty()) {
            throw new IllegalArgumentException("invalid results: cannot be null or empty");
        }

        return new Results(results);
    }

    public ResultCount count() {
        return new ResultCount(size());
    }

    public Results mapByIndex(List<Integer> indexes) {
        return of(indexes.stream()
                .map(this::elementOf)
                .collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return "Results {" +
                super.toString() +
                '}';
    }
}
