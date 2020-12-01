package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Results {

    public static final String SPLITTER = ",";
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public static Results from(String resultList) {
        return new Results(Arrays.stream(resultList.split(SPLITTER))
                .map(Result::new)
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
}
