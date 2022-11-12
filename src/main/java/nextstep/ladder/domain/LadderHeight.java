package nextstep.ladder.domain;

public class LadderHeight {

    private static final int MIN_HEIGHT = 2;

    private final int value;

    public LadderHeight(int value) {
        validateMinLength(value);
        this.value = value;
    }

    private void validateMinLength(int value) {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 최소 높이보다 커야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
