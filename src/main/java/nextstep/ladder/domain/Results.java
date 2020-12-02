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

    public static Results from(int width, String resultsString) {
        List<Result> results = Arrays.stream(resultsString.split(SPLITTER))
                .map(Result::new)
                .collect(Collectors.toList());
        checkSize(width, results);

        return new Results(results);
    }

    private static void checkSize(int width, List<Result> resultList) {
        if (resultList.size() != width) {
            throw new IllegalArgumentException("width and results size is different");
        }
    }

    public int getSize() {
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

    public Result get(int idx) {
        return results.get(idx);
    }
}
