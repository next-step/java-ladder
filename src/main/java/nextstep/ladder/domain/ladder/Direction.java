package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Direction {

    public static final int LEFT = -1;
    public static final int RIGHT = 1;
    public static final int DOWN = -1;

    private final int direction;

    public Direction(int direction) {
        validate(direction);
        this.direction = direction;
    }

    public static Direction of(int direction) {
        return new Direction(direction);
    }

    private void validate(int direction) {
        if (direction != LEFT && direction != RIGHT && direction != DOWN) {
            throw new IllegalArgumentException(direction + " 은 잘못된 방향입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction1 = (Direction) o;
        return direction == direction1.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}
