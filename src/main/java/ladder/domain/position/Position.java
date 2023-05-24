package ladder.domain.position;

import java.util.Objects;
import ladder.domain.line.Line;
import ladder.domain.moving.Moving;
import ladder.domain.moving.MovingStrategy;

public class Position {

    private final int height;
    private final int width;

    public Position(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public static Position of(int height, int width) {
        return new Position(height, width);
    }

    public Position move(MovingStrategy movingStrategy, Line line) {
        Moving moving = movingStrategy.nextMoving(line, width);
        return new Position(height + moving.vertical(), width + moving.horizontal());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return height == position.height && width == position.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }

    @Override
    public String toString() {
        return "Position{" +
            "height=" + height +
            ", width=" + width +
            '}';
    }

    public Position clone() {
        return Position.of(height, width);
    }

    public int width() {
        return width;
    }

}
