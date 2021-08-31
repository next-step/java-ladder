package ladder.model;

public class LadderPoint {
    private static final int MIN_INDEX = 0;

    private final int index;
    private final LadderDirection direction;

    LadderPoint(int index, LadderDirection direction) {
        validateNonNegative(index);
        this.index = index;
        this.direction = direction;
    }

    private void validateNonNegative(int index) {
        if (index < MIN_INDEX) {
            throw new IllegalArgumentException(String.format("포인트 인덱스는 %d이상 이어야 합니다.", MIN_INDEX));
        }
    }
}
