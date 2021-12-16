package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Results extends FirstClassList<Result> {
    private Results(final List<Result> results) {
        super(results);
    }

    public static Results of(final List<String> results) {
        if (results == null || results.isEmpty()) {
            throw new IllegalArgumentException("invalid results: cannot be null or empty");
        }

        return new Results(results.stream()
                .map(Result::of)
                .collect(Collectors.toList()));
    }

    public ResultCount count() {
        return new ResultCount(size());
    }

    @Override
    public String toString() {
        return "Results {" +
                super.toString() +
                '}';
    }
}
