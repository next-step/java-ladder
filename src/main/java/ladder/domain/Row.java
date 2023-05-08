package ladder.domain;

public class Row {
    private final int value;

    public Row(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
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
