package ladder.domain.model;

import java.util.Objects;

public class Index {
    public static final int START_INDEX = 0;
    private int index;

    private Index(int index) {
        validateRange(index);
        this.index = index;
    }

    public static Index of(int index) {
        return new Index(index);
    }

    private void validateRange(int index) {
        if (index < START_INDEX) {
            throw new IllegalArgumentException("Invalid index range");
        }
    }

    public int prev() {
        return index == START_INDEX ? START_INDEX : index - 1;
    }

    public int get() {
        return index;
    }

    public int next() {
        return index + 1;
    }

    public boolean isStartIndex() {
        return index == START_INDEX;
    }

    public boolean isSameIndex(int index) {
        return this.index == index;
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
        return "Index{" +
                "index=" + index +
                '}';
    }
}
