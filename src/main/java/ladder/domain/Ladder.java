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

    public void move(Players players) {
        for (Player player : players.players()) {
            rows.forEach(row -> row.move(player));
        }
    }

    public List<Row> rows() {
        return Collections.unmodifiableList(rows);
    }
}
