package nextstep.ladder.domain;

public class Height {
    private static final String LADDER_HEIGHT_LESS_THAN_STANDARD_ERROR_MESSAGE = "사다리의 높이는 0보다 커야합니다. (입력된 사다리의 높이: %d)";
    private static final int LADDER_HEIGHT_MINIMUM_BOUNDARY = 1;

    private final int value;

    public Height(int value) {
        validateBoundary(value);
        this.value = value;
    }

    private void validateBoundary(int height) {
        if (height < LADDER_HEIGHT_MINIMUM_BOUNDARY) {
            throw new IllegalArgumentException(String.format(LADDER_HEIGHT_LESS_THAN_STANDARD_ERROR_MESSAGE, height));
        }
    }

    public int getValue() {
        return value;
    }
}
