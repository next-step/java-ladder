package nextstep.ladder.domain.ladder;

import nextstep.ladder.application.CreatePointStrategy;

import java.util.Objects;

public class Point {
    private Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public void drawRightLine(Point nextLinePoint, CreatePointStrategy createPointStrategy) {
        if(direction.equals(Direction.NONE) && createPointStrategy.isDraw()) {
            direction = Direction.RIGHT;
            nextLinePoint.drawLeftLine();
        }
    }

    private void drawLeftLine() {
        direction = Direction.LEFT;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return direction == point.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}
