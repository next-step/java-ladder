package ladder.domain.result;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Results {

    private final List<Result> results;

    public Results(final List<String> results) {
        this.results = results.stream()
                .map(Result::valueOf)
                .collect(Collectors.toList());
    }

    public Result get(final int index) {
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
}
