package nextstep.ladder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    public Results(String[] resultArray) {
        results = Arrays.stream(resultArray).
                map(Result::new)
                .collect(Collectors.toList());
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }

    public String getResultByIndex(int index) {
        return results.get(index).getResult();
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
