package ladder.domain;

public class Height {

    private static final int MIN_VALUE = 2;

    private final int value;

    private Height(int value) {
        if (isLessThanMinValue(value)) {
            throw new IllegalArgumentException("높이는 2이상만 가능합니다.");
        }

        this.value = value;
    }

    private boolean isLessThanMinValue(int value) {
        return value < MIN_VALUE;
    }

    public static Height valueOf(int value) {
        return new Height(value);
    }

    public int getValue() {
        return value;
    }
}
