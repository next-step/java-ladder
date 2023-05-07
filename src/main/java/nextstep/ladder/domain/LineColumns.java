package nextstep.ladder.domain;

import nextstep.ladder.domain.generator.RandomBooleanGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineColumns {

    private final List<LineRows> rows;

    public LineColumns(List<LineRows> rows) {
        this.rows = rows;
    }

    public static LineColumns create(int columnLength, int rowLength) {
        return new LineColumns(
                IntStream.range(0, columnLength)
                        .mapToObj(index -> LineRows.initialize(rowLength, new RandomBooleanGenerator()))
                        .collect(Collectors.toUnmodifiableList()));
    }

    public List<LineRows> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return "LineColumns{" +
                "rows=" + rows +
                '}';
    }

}
