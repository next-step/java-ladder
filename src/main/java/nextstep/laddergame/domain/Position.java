package nextstep.laddergame.domain;

import nextstep.laddergame.service.PositionDirection;

import java.util.Objects;

public class Position {
    private static final Integer INIT_POSITION = 0;

    private final int position;

    public Position() {
        this(INIT_POSITION);
    }

    public Position(int position) {
        this.position = position;
    }

    public Position deepCopy() {
        return new Position(position);
    }

    public Position next() {
        return new Position(this.position + 1);
    }

    public Position move(PositionDirection direction) {
        return new Position(position + direction.getValue());
    }

    public boolean isFirst() {
        return position == 0;
    }

    public int value() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }
}
