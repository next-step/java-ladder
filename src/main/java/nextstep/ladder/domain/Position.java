package nextstep.ladder.domain;

import java.util.Objects;

public class Position {
    private static final int MIN_POSITION = 0;
    private final int position;

    private Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    public static Position from(int position) {
        return new Position(position);
    }

    public static Position first() {
        return new Position(MIN_POSITION);
    }

    public Position decrease() {
        if (position == MIN_POSITION) {
            throw new IllegalArgumentException("[ERROR] 위치는 " + MIN_POSITION + "이상이어야 합니다.");
        }
        return new Position(position - 1);
    }

    public Position increase() {
        return new Position(position + 1);
    }

    private void validatePosition(int position) {
        if (position < MIN_POSITION) {
            throw new IllegalArgumentException("[ERROR] 위치는 " + MIN_POSITION + "이상이어야 합니다.");
        }
    }

    public int value() {
        return position;
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
