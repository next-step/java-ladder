package ladder.domain.line;

public class Height {

    private static final int MIN_VALUE = 1;

    private final int value;

    private Height(int value) {
        if (isLessThanMinValue(value)) {
            throw new IllegalArgumentException(String.format("높이는 %d이상만 가능합니다.", MIN_VALUE));
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
