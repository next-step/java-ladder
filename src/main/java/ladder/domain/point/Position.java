package ladder.domain.point;

import java.util.Objects;

public class Position {
    static final int INITIAL_POSITION = 0;

    private final int value;

    public Position(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int position) {
        if (position < INITIAL_POSITION) {
            throw new IllegalArgumentException(String.format("position(%s)은 초기값(%s) 미만 일 수 없습니다.", position, INITIAL_POSITION));
        }
    }

    public Position move(Direction direction) {
        return new Position(direction.move(value));
    }

    public Position next() {
        return new Position(Direction.RIGHT.move(value));
    }

    public static Position value(int position) {
        return new Position(position);
    }

    public static Position initialize() {
        return new Position(INITIAL_POSITION);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
