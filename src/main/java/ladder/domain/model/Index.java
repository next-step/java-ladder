package ladder.domain.model;

import java.util.Objects;

public class Index {
    public static final int START_INDEX = 0;
    private int index;

    private Index(int index) {
        validateRange(index);
        this.index = index;
    }

    private static Index of(int index) {
        return new Index(index);
    }

    public static Index ofStart() {
        return of(START_INDEX);
    }

    private void validateRange(int index) {
        if (index < START_INDEX) {
            throw new IllegalArgumentException("Invalid index range");
        }
    }

    public Index next() {
        return Index.of(index + 1);
    }

    public Index prev() {
        validateRange(index);
        return Index.of(index - 1);
    }

    public int get() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Index index1 = (Index) o;
        return index == index1.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

    @Override
    public String toString() {
        return String.valueOf(index);
    }
}
