package ladder.domain;

import ladder.exception.OutOfRoWRangeException;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private static final int MAX_ROW = 50;

    private static final List<Row> ROW_CACHE = new ArrayList<>(MAX_ROW + 1);

    static {
        for (int i = 0; i <= MAX_ROW; i++) {
            ROW_CACHE.add(i, new Row(i));
        }
    }

    private final int value;

    private Row(int value) {
        this.value = value;
    }

    public static Row of(int value) {
        validateMaxRow(value);
        return ROW_CACHE.get(value);
    }

    private static void validateMaxRow(int value) {
        if ((0 <= value) && (value <= MAX_ROW)) {
            return;
        }
        throw new OutOfRoWRangeException();
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
