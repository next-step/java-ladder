package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public ResultCount count() {
        return new ResultCount(results.size());
    }

    public Stream<Result> stream() {
        return results.stream();
    }

    public List<Result> collect() {
        return results;
    }

    public Result get(int index) {
        return results.get(index);
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
