package ladder.domain.result;

import ladder.domain.enums.Direction;
import ladder.domain.ladder.Line;

import java.util.Objects;

public class Position {
    private static final int STARTING_POSITION = 0;
    private int position;

    private Position(int position) {
        this.position = position;
    }

    static Position of(int position) {
        return new Position(position);
    }

    public Position goLeft() {
        if (position == STARTING_POSITION) {
            throw new RuntimeException();
        }
        this.position--;
        return this;
    }

    public Position goRight() {
        this.position++;
        return this;
    }

    public Direction getDirection(Line line) {
        if (isFirst())
            return Direction.of(false, line.getRightPoint(position));
        if (isLast(line))
            return Direction.of(line.getLeftPoint(position), false);

        return Direction.of(line.getLeftPoint(position), line.getRightPoint(position));
    }

    private boolean isFirst() {
        return position == STARTING_POSITION;
    }

    private boolean isLast(Line line) {
        return position == line.getPoints().size() - 1;
    }

    public int getPrimitive() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
