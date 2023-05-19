package ladder.domain;

import ladder.control.Preferences;
import ladder.exception.OutOfRoWRangeException;

public class Row {
    private static final Row[] ROW_CACHE = new Row[Preferences.maxRowPolicy() + 1];

    static {
        for (int i = 0; i <= Preferences.maxRowPolicy(); i++) {
            ROW_CACHE[i] = new Row(i);
        }
    }

    private final int value;

    private Row(int value) {
        this.value = value;
    }

    public static Row of(int value) {
        validateMaxRow(value);
        return ROW_CACHE[value];
    }

    private static void validateMaxRow(int value) {
        if ((0 <= value) && (value <= Preferences.maxRowPolicy())) {
            return;
        }
        throw new OutOfRoWRangeException();
    }

    public boolean isSame(Row otherRow) {
        return this.value == otherRow.value;
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
