package nextstep.ladder;

public class LadderMaxHeight {
    private static final int MIN_VALUE = 2;

    private final int value;

    public LadderMaxHeight(int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException("최대 사다리 높이는 최소 2 이상이어야 합니다.");
        }

        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
