package ladder.model;

import ladder.strategy.LadderGenerationStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Ladder {
    private final List<LadderRow> rows;

    private Ladder(List<LadderRow> rows) {
        this.rows = Collections.unmodifiableList(rows);
    }

    public static Ladder create(Width width, Height height, LadderGenerationStrategy strategy) {
        List<LadderRow> rows = Stream.generate(() -> LadderRow.create(width, strategy))
                .limit(height.value())
                .collect(toList());

        return new Ladder(rows);
    }

    public int width() {
        return rows.get(0).size();
    }

    public int height() {
        return rows.size();
    }

    public boolean exists(int row, int column) {
        return rows.get(row).exists(column);
    }

    public LadderRow rowAt(int index) {
        return rows.get(index);
    }

    public List<LadderRow> rows() {
        return rows;
    }
}
