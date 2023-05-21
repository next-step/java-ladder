package nextstep.ladder.domain.ladder;

public enum ConnectionType {
    LEFT(-1),
    RIGHT(1),
    NONE(0);

    private final int movePoint;

    ConnectionType(int movePoint) {
        this.movePoint = movePoint;
    }

    public static ConnectionType getRightOrNone(boolean isRight) {
        if (isRight) {
            return RIGHT;
        }
        return NONE;
    }

    public int getMovePoint() {
        return movePoint;
    }

    public boolean isRight() {
        return this == RIGHT;
    }

}
