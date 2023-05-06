package ladder.model;

public class Width implements Comparable<Width> {
    private final int value;

    public Width(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("must be positive:" + value);
        }
        this.value = value;
    }

    public int value() {
        return value;
    }

    @Override
    public int compareTo(Width o) {
        return Integer.compare(this.value, o.value);
    }
}
