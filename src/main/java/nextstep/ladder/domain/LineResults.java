package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LineResults {
    private List<LineResult> lineResults;

    public LineResults(List<LineResult> lineResults) {
        this.lineResults = new ArrayList<>(lineResults);
    }

    public void add(LineResult lineResult) {
        this.lineResults.add(lineResult);
    }

    public LineResult getLast() {
        return lineResults.get(lineResults.size() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineResults that = (LineResults) o;
        return Objects.equals(lineResults, that.lineResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineResults);
    }
}
