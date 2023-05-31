package ladder.domain;

import ladder.exception.OutOfColumnRangeException;
import ladder.exception.OutOfRoWRangeException;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private static final int ROW_CACHE_MAX = 50;

    private static final List<Row> ROW_CACHE = new ArrayList<>(ROW_CACHE_MAX + 1);

    static {
        for (int i = 0; i <= ROW_CACHE_MAX; i++) {
            ROW_CACHE.add(i, new Row(i));
        }
    }

    private final int value;

    private Row(int value) {
        this.value = value;
    }

    public static Row of(int value) {
        if(value <0) {
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
