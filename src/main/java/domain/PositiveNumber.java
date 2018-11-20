package domain;

public class PositiveNumber {

    private static final int MIN_BOUND = 1;

    private final int value;

    private PositiveNumber(int value) {
        if (value < MIN_BOUND) {
            throw new IllegalArgumentException("값은 양수여야 한다.");
        }

        this.value = value;
    }

    public static PositiveNumber from(int value) {
        return new PositiveNumber(value);
    }

    public int value() {
        return value;
    }
}
