package ladder.domain;

public enum Direction {
    LEFT(-1),
    STAY(0),
    RIGHT(1);

    private static final String DIRECTION_INVALID_EXCEPTION_MESSAGE = "사다리 타기가 정상적으로 동작하려면 겹치지 않아야 합니다!";

    private int indexDifference;

    Direction(int indexDifference) {
        this.indexDifference = indexDifference;
    }

    public int move(int index) {
        return index + indexDifference;
    }

    public static Direction first(boolean shouldMove) {

        return STAY;
    }

    public Direction next() {
       return STAY;
    }

    public Direction next(boolean moveRight) {
       return STAY;
    }

    public Direction last() {
        return STAY;
    }
}
