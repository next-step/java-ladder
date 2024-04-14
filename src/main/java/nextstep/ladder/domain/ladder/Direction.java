package nextstep.ladder.domain.ladder;

public enum Direction {
    LEFT,
    RIGHT,
    NONE
    ;

    public boolean isLeft() {
        return this == LEFT;
    }

    public boolean isRight() {
        return this == RIGHT;
    }

    public ColumnIndex next(ColumnIndex currentIndex) {
        if (this == LEFT) {
            return currentIndex.before();
        }

        if (this == RIGHT) {
            return currentIndex.next();
        }

        return currentIndex;
    }
}
