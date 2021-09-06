package ladder.model;

public class LadderPoint {
    private static final int FIRST_INDEX = 0;
    private static final int MIN_INDEX = 0;
    private static final int INDEX_GAP_BETWEEN_CURRENT_AND_NEXT_POINT = 1;

    private final int index;
    private final LadderDirection direction;

    LadderPoint(int index, LadderDirection direction) {
        validateNonNegative(index);
        this.index = index;
        this.direction = direction;
    }

    static LadderPoint first() {
        return new LadderPoint(FIRST_INDEX, LadderDirection.first());
    }

    static LadderPoint first(boolean right) {
        return new LadderPoint(FIRST_INDEX, LadderDirection.first(right));
    }

    LadderPoint next() {
        int nextPointIndex = index + INDEX_GAP_BETWEEN_CURRENT_AND_NEXT_POINT;
        return new LadderPoint(nextPointIndex, direction.next());
    }

    LadderPoint last() {
        int lastPointIndex = index + INDEX_GAP_BETWEEN_CURRENT_AND_NEXT_POINT;
        return new LadderPoint(lastPointIndex, direction.last());
    }

    private void validateNonNegative(int index) {
        if (index < MIN_INDEX) {
            throw new IllegalArgumentException(String.format("포인트 인덱스는 %d이상 이어야 합니다.", MIN_INDEX));
        }
    }

    int move() {
        if (direction.isRight()) {
            return index + INDEX_GAP_BETWEEN_CURRENT_AND_NEXT_POINT;
        }

        if (direction.isLeft()) {
            return index - INDEX_GAP_BETWEEN_CURRENT_AND_NEXT_POINT;
        }

        return index;
    }

    public boolean isRight() {
        return direction.isRight();
    }
}
