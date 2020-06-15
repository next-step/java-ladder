package nextstep.ladder.domain.game;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    public Results(List<String> results) {
        if (Objects.isNull(results)) {
            throw new IllegalArgumentException("inject result list is null in results constructor");
        }
        this.results = createResults(results);
    }

    private List<Result> createResults(List<String> results) {
        return results.stream()
                .map(Result::from)
                .collect(Collectors.toList());
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
}
