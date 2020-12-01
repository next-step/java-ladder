package nextstep.ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LineResult {

    public static final String SPLITTER = ",";
    private final List<Result> results;

    public LineResult(List<Result> results) {
        this.results = new ArrayList<>(results);
    }

    public static LineResult from(int length, String results) {
        List<Result> resultList = Arrays.stream(results.split(SPLITTER))
                .map(Result::new)
                .collect(Collectors.toList());
        checkSize(length, resultList);

        return new LineResult(resultList);
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
        LineResult lineResult1 = (LineResult) o;
        return Objects.equals(results, lineResult1.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
