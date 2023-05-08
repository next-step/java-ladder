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
}
