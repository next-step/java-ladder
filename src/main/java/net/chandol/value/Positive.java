package net.chandol.value;

public class Positive {
    public static final Positive ZERO = Positive.pos(0);
    private int value;

    private Positive(int value) {
        if(value < 0) {
            throw new IllegalStateException("");
        }

        this.value = value;
    }

    public int value() {
        return value;
    }

    public static Positive pos(int value) {
        return new Positive(value);
    }

    public Positive increase() {
        return new Positive(value + 1);
    }

    public Positive decrease() {
        return new Positive(value - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Positive positive = (Positive) o;

        return value == positive.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
