package nextstep.ladder.domain;

public class Height {
    public static final String INVALID_HEIGHT_VALUE_ERR_MSG = "사다리의 높이는 1이상이어야 합니다.";
    private static final int MIN_AVAILABLE_HEIGHT_VALUE = 1;
    private final int value;

    private Height(int value) {
        this.value = value;
        validateValue(this.value);
    }

    private void validateValue(int value) {
        if (value < MIN_AVAILABLE_HEIGHT_VALUE) {
            throw new IllegalArgumentException(INVALID_HEIGHT_VALUE_ERR_MSG);
        }
    }

    public static Height valueOf(int value) {
        return new Height(value);
    }

    public int getValue() {
        return value;
    }
}
