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

    public static Ladder of(LadderRow... rows) {
        return new Ladder(List.of(rows));
    }

    public static Ladder create(int stiles, int height, LadderGenerationStrategy strategy) {
        if (height <= 0) {
            throw new IllegalArgumentException("the height of ladder must be positive:" + height);
        }

        return new Ladder(Stream.generate(() -> LadderRow.create(stiles, strategy))
                .limit(height)
                .collect(toList())
        );
    }

    public int width() {
        return rows.get(0).width();
    }

    public int height() {
        return rows.size();
    }

    public int countOfStiles() {
        return rows.get(0).stiles().size();
    }
    

    public List<LadderRow> rows() {
        return rows;
    }

    public int resultOf(int stileIndex) {
        if (stileIndex < 0 || stileIndex >= countOfStiles()) {
            throw new IndexOutOfBoundsException("invalid index of stile:" + stileIndex);
        }

        int result = stileIndex;

        for (int depth = 0; depth < height(); depth++) {
            LadderRow row = rows.get(depth);
            result = row.nextStile(result);
        }

        return result;
    }
}
