package ladder.domain;

import ladder.strategy.RowStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<Row> rows;

    private Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public static Ladder from(LadderSize ladderSize, RowStrategy rowStrategy) {
        return new Ladder(
                Stream.generate(() -> Row.from(rowStrategy.generate(ladderSize.width())))
                        .limit(ladderSize.height())
                        .collect(Collectors.toList()));
    }

    public int move(int position) {

        for (Row row : rows) {
            position = row.move(position);
        }

        return position;
    }

    public List<Row> values() {
        return Collections.unmodifiableList(rows);
    }
}
