package nextstep.ladder;

public class Natural implements Comparable<Natural> {
    private final Long value;

    public Natural(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("Negative value given for natural number");
        }
        this.value = value;
    }

    public Long value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Natural) {
            return value.equals(((Natural) o).value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public int compareTo(Natural o) {
        return value.compareTo(o.value);
    }
}
