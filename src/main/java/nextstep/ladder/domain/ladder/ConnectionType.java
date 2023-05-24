package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.user.Position;

public enum ConnectionType {
    LEFT(new Position(-1), "     "),
    RIGHT(new Position(1), "-----"),
    NONE(new Position(0), "     ");

    private final Position movePosition;
    private final String output;

    ConnectionType(Position movePosition, String output) {
        this.movePosition = movePosition;
        this.output = output;
    }

    public static ConnectionType getRightOrNone(boolean isRight) {
        if (isRight) {
            return RIGHT;
        }
        return NONE;
    }

    public String toOutput() {
        return output;
    }

    public boolean isRight() {
        return this == RIGHT;
    }

    public Position applyPosition(Position userPosition) {
        return userPosition.move(movePosition);
    }
}
