package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    private Results(final List<Result> results) {
        this.results = Collections.unmodifiableList(results);
    }

    public static Results of(final List<String> results) {
        if (results == null || results.isEmpty()) {
            throw new IllegalArgumentException("invalid results: cannot be null or empty");
        }

        return new Results(results.stream()
                .map(Result::of)
                .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results1 = (Results) o;
        return Objects.equals(results, results1.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public String toString() {
        return "Results{" +
                "results=" + results +
                '}';
    }
}
