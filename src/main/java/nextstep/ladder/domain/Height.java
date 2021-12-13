package nextstep.ladder.domain;

public class Height {
    private static final int MINIMUM_HEIGHT = 1;

    private final int value;

    public Height(int value) {
        validValue(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validValue(int value) {
        if (value < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리의 높이는 %d이상 이어야 합니다", MINIMUM_HEIGHT));
        }
    }
}
