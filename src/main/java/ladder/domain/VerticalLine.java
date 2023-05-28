package ladder.domain;

import ladder.domain.enums.Direction;

public class VerticalLine {
    public final Direction connectDirection;

    public VerticalLine(Direction connectDirection) {
        this.connectDirection = connectDirection;
    }

    public int getNextPosition(int currentPosition) {
        return currentPosition + connectDirection.getValue();
    }

    public boolean hasRightConnection() {
        return connectDirection.equals(Direction.RIGHT);
    }
}
