package nextstep.ladder.domain;

import java.util.Objects;

public class Position {

    public static final int DEFAULT_MOVE_POSITION = 1;

    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position newInstance(int position) {
        validate(position);
        return new Position(position);
    }

    private static void validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 0보다 커야 합니다.");
        }
    }

    public Position left() {
        return new Position(this.position - DEFAULT_MOVE_POSITION);
    }

    public Position right() {
        return new Position(this.position + DEFAULT_MOVE_POSITION);
    }

    public int value() {
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
