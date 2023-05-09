package ladder.model.ladder;

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

    public static Ladder create(int width, int height, LadderGenerationStrategy strategy) {
        if (height <= 0) {
            throw new IllegalArgumentException("the height of ladder must be positive:" + height);
        }

        return new Ladder(Stream.generate(() -> LadderRow.create(width, strategy))
                .limit(height)
                .collect(toList())
        );
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
