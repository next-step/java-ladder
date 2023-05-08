package ladder.domain;

import ladder.control.Preferences;
import ladder.exception.OutOfColumnRangeException;

import java.util.Objects;

public class Column {
    private final int value;
    private static final Column[] COLUMNS_CACHE = new Column[Preferences.maxColumnPolicy()];
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

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Column column = (Column) o;
        return value == column.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
