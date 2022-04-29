package nextstep.ladder.model;

import nextstep.common.Assert;

import java.util.Objects;

public final class Positive {

    public static final Positive ONE = from(1);

    private final int value;

    private Positive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(String.format("positive value(%d) must be positive", value));
        }
        this.value = value;
    }

    public static Positive from(int value) {
        return new Positive(value);
    }

    Positive add(Positive positive) {
        Assert.notNull(positive, "positive to add must not be null");
        return from(this.value + positive.value);
    }

    boolean lessThan(Positive positive) {
        Assert.notNull(positive, "positive to compare must not be null");
        return value < positive.value;
    }

    boolean lessThanOrEqual(Positive positive) {
        return lessThan(positive) || this.value == positive.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Positive positive = (Positive) o;
        return value == positive.value;
    }

    @Override
    public String toString() {
        return "Positive{" +
                "value=" + value +
                '}';
    }
}
