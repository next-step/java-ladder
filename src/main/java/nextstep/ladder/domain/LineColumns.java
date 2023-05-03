package nextstep.ladder.domain;

import nextstep.ladder.domain.generator.RandomBooleanGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineColumns {

    private final List<LineRows> columns;

    public LineColumns(List<LineRows> columns) {
        this.columns = columns;
    }

    public static LineColumns create(int height, int userCount) {
        return new LineColumns(
                IntStream.range(0, height)
                        .mapToObj(index -> LineRows.initialize(userCount, new RandomBooleanGenerator()))
                        .collect(Collectors.toUnmodifiableList()));
    }

    public List<LineRows> getColumns() {
        return columns;
    }

}
