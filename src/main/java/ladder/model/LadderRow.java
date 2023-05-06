package ladder.model;

import ladder.strategy.LadderGenerationStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LadderRow {
    private final List<Boolean> row;

    public LadderRow(List<Boolean> row) {
        this.row = Collections.unmodifiableList(row);
    }

    public static LadderRow create(Width width, LadderGenerationStrategy strategy) {
        List<Boolean> values = Stream.iterate(strategy.first(), strategy::next)
                .limit(width.value())
                .collect(toList());

        return new LadderRow(values);
    }

    public int size() {
        return row.size();
    }

    public boolean exists(int column) {
        return row.get(column);
    }

}
