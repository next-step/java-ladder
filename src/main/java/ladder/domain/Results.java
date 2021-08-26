package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Results {

    private static final String SEPARATOR = ",";

    private final List<Result> results;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results create(String results) {
        return Arrays.stream(results.split(SEPARATOR))
                .map(Result::create)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Results::new));
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
}
