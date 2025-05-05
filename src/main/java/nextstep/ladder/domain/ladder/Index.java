package nextstep.ladder.domain.ladder;

public class Index {
    private final int value;
    private final int max;

    public Index(int value, int max) {
        validate(value, max);
        this.value = value;
        this.max = max;
    }

    private void validate(int value, int max) {
        if (value < 0 || value >= max) {
            throw new IllegalArgumentException("인덱스는 0 이상 " + (max - 1) + " 이하여야 합니다.");
        }
    }

    public int value() {
        return value;
    }

    public Index increment() {
        return new Index(value + 1, max);
    }

    public Index decrement() {
        return new Index(value - 1, max);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Index index = (Index) o;
        return value == index.value && max == index.max;
    }

    @Override
    public int hashCode() {
        return value;
    }
} 