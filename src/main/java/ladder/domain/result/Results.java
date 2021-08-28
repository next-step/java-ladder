package ladder.domain.result;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Results {

    private final List<Result> results;

    private Results(final List<Result> results) {
        this.results = results;
    }

    public static Results of(final List<String> resultValues) {
        List<Result> results = resultValues.stream()
                .map(Result::valueOf)
                .collect(Collectors.toList());

        return new Results(results);
    }

    public Result get(final int index) {
        return results.get(index);
    }

    public int size() {
        return results.size();
    }

    public List<Result> getResults() {
        return results;
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
