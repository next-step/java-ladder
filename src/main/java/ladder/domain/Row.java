package ladder.domain;

import ladder.exception.OutOfRoWRangeException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Row {
    private static final int ROW_CACHE_MAX = 50;

    private static final List<Row> ROW_CACHE =
            IntStream.rangeClosed(0, ROW_CACHE_MAX)
                    .boxed()
                    .map(Row::new)
                    .collect(Collectors.toList());
    private final int value;

    private Row(int value) {
        this.value = value;
    }

    public static Row of(int value) {
        if (value < 0) {
            throw new OutOfRoWRangeException();
        }
        if (value <= ROW_CACHE_MAX) {
            return ROW_CACHE.get(value);
        }
        return new Row(value);
    }

    public boolean isSame(Row otherRow) {
        return this.value == otherRow.value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Row otherRow = (Row) o;
        return this.hashCode() == otherRow.hashCode();
    }
}
