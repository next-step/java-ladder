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

    public static Results from(int length, String results) {
        List<Result> resultList = Arrays.stream(results.split(SPLITTER))
                .map(Result::new)
                .collect(Collectors.toList());
        checkSize(length, resultList);

        return new Results(resultList);
    }

    private static void checkSize(int length, List<Result> resultList) {
        if (resultList.size() != length) {
            throw new IllegalArgumentException("length and results size is different");
        }
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
