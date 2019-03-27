package ladder.vo;

public class Length {
    private static final int MIN_LENGTH = 1;

    private final int value;

    public Length(int value) {
        if (value < MIN_LENGTH) {
            throw new IllegalArgumentException();
        }

        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
