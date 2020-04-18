package ladder.ladder.domain;

import java.util.Objects;

public class Index {
    private static final int ZERO = 0;
    private static final int INDEX_DEFAULT_STEP = 1;

    private final int index;

    private Index(int index) {
        validateNegative(index);
        this.index = index;
    }

    public static Index init() {
        return new Index(ZERO);
    }

    public static Index of(int index) {
        return new Index(index);
    }

    private void validateNegative(int index) {
        if (index < ZERO) {
            throw new NegativeIndexException();
        }
    }

    public int getIndex() {
        return index;
    }

    public Index increase() {
        return Index.of(index + INDEX_DEFAULT_STEP);
    }

    public Index decrease() {
        return Index.of(index - INDEX_DEFAULT_STEP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Index)) return false;
        Index index1 = (Index) o;
        return getIndex() == index1.getIndex();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIndex());
    }

    @Override
    public String toString() {
        return "Index{" +
                "index=" + index +
                '}';
    }
}
