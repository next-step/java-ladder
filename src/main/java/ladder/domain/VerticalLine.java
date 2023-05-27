package ladder.domain;

import ladder.domain.enums.Direction;

import java.awt.*;

public class VerticalLine {
    private final Direction connectDirection;

    public VerticalLine(Direction connectDirection) {
        this.connectDirection = connectDirection;
    }

    public int getNextPosition(int position) {
        return position + connectDirection.getValue();
    }
}
