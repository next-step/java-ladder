package ladder.model;

import ladder.strategy.LadderGenerationStrategy;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class LadderRow {
    private final List<Boolean> row;

    public LadderRow(List<Boolean> row) {
        validateOverlapped(row);
        this.row = Collections.unmodifiableList(row);
    }

    public static LadderRow create(int width, LadderGenerationStrategy strategy) {
        validate(width, strategy);

        return new LadderRow(Stream.iterate(strategy.first(), strategy::next)
                .limit(width)
                .collect(toList())
        );
    }

    private static void validate(int width, LadderGenerationStrategy strategy) {
        Objects.requireNonNull(strategy);
        if (width <= 0) {
            throw new IllegalArgumentException("the width of ladder must be positive:" + width);
        }
    }

    private static void validateOverlapped(List<Boolean> row) {
        range(0, row.size() - 1)
                .filter(i -> row.get(i) && row.get(i) == row.get(i + 1))
                .findFirst()
                .ifPresent((same) -> {
                    throw new IllegalArgumentException("adjacent values cannot be `true`");
                });
    }


    public int size() {
        return row.size();
    }

    public boolean exists(int column) {
        return row.get(column);
    }

}
