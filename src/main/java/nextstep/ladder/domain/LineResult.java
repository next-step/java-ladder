package nextstep.ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LineResult {

    public static final String SPLITTER = ",";
    private final List<Result> results;

    public LineResult(List<Result> results) {
        this.results = new ArrayList<>(results);
    }

    public static LineResult from(int width, String results) {
        List<Result> resultList = Arrays.stream(results.split(SPLITTER))
                .map(Result::new)
                .collect(Collectors.toList());
        checkSize(width, resultList);

        return new LineResult(resultList);
    }

    private static void checkSize(int width, List<Result> resultList) {
        if (resultList.size() != width) {
            throw new IllegalArgumentException("width and results size is different");
        }
    }

    public void swapWithNextPosition(int position) {
        Collections.swap(this.results, position, position + 1);
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

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
