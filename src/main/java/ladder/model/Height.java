package ladder.model;

public class Height implements Comparable<Height> {
    private final int value;

    public Height(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("must be positive:" + value);
        }
        this.value = value;
    }


    @Override
    public int compareTo(Height o) {
        return Integer.compare(this.value, o.value);
    }
}
