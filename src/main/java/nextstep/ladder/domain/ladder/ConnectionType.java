package nextstep.ladder.domain.ladder;

public enum ConnectionType {
    LEFT(-1, "     "),
    RIGHT(1, "-----"),
    NONE(0, "     ");

    private final int movePoint;
    private final String output;

    ConnectionType(int movePoint, String output) {
        this.movePoint = movePoint;
        this.output = output;
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

    public String toOutput() {
        return output;
    }

    public boolean isRight() {
        return this == RIGHT;
    }

}
