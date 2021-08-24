package nextstep.ladder.domain;

import java.util.Objects;

public class Point {

    private static final String NON_NULL = "입력값은 null 일 수 없습니다";
    private static final String LESS_THAN_ZERO = "위치 값은 0보다 작을 수 없습니다 -> %d";
    private static final String INVALID_DIRECTION = "0의 위치에서는 LEFT (direction) 값을 가질 수 없습니다";
    private static final int ZERO = 0;

    private final int position;
    private final Direction direction;

    public Point(final int position, final Direction direction) {
        validatePosition(position);
        this.position = position;
        validateDirection(direction);
        this.direction = direction;
    }

    public boolean isRightDirection() {
        return direction.equals(Direction.RIGHT);
    }

    private void validatePosition(final int position) {
        if (position < ZERO) {
            throw new IllegalArgumentException(String.format(LESS_THAN_ZERO, position));
        }
    }

    private void validateDirection(final Direction direction) {
        requireNonNull(direction);
        requireValidDirection(direction);
    }

    private void requireValidDirection(final Direction direction) {
        if (position == ZERO && direction.equals(Direction.LEFT)) {
            throw new IllegalArgumentException(INVALID_DIRECTION);
        }
    }

    private void requireNonNull(final Direction direction) {
        if (Objects.isNull(direction)) {
            throw new IllegalArgumentException(NON_NULL);
        }
    }

}
