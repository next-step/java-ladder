package nextstep.step2.VO;

import javafx.geometry.Pos;

public class Point {
    private final Direction direction;
    private final Position position;

    public Point(Position position, Direction direction) {
        this.direction = direction;
        this.position = position;
    }

    public Position getNextPosition() {
        return direction.getNextPosition(this.position);
    }

    public Direction getDirection() {
        return direction;
    }

    public Position getPosition() {
        return position;
    }
}
