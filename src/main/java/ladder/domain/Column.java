package ladder.domain;

import ladder.control.Preferences;
import ladder.exception.OutOfColumnRangeException;

public class Column {
    private final int value;
    private static final Column[] COLUMNS_CACHE = new Column[Preferences.maxColumnPolicy()+1];
    static {
        for(int i=0 ; i<=Preferences.maxColumnPolicy() ; i++) {
            COLUMNS_CACHE[i] = new Column(i);
        }
    }
    private Column(int value) {
        this.value = value;
    }

    public static Column of(int value) {
        if(value>Preferences.maxColumnPolicy()) {
            throw new OutOfColumnRangeException();
        }
        return COLUMNS_CACHE[value];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Column otherColumn = (Column) o;
        return this.hashCode() == otherColumn.hashCode();
    }

    @Override
    public int hashCode() {
        return value;
    }

    public boolean isAdjacent(Column other) {
        return Math.abs(this.value - other.value) <= 1;
    }

    public boolean isSame(Column other) {
        return equals(other);
    }
}
