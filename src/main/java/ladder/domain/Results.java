package ladder.domain;

import ladder.utils.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Results {
    List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public static Results of(String value) {
        List<Result> results = Optional.ofNullable(value)
                .map(v -> toResults(StringUtils.splitComma(v)))
                .orElseThrow(() -> new IllegalArgumentException());
        return new Results(results);
    }

    private static List<Result> toResults(String[] values) {
        return Arrays.stream(values)
                .map(Result::of)
                .collect(Collectors.toList());
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
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

    public Result getResult(int i) {
        return results.get(i);
    }
}