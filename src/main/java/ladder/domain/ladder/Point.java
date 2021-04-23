package ladder.domain.ladder;

import ladder.exception.InputNegativeNumberException;

public final class Point {

    private static final int ZERO = 0;

    private final int position;
    private final Direction direction;

    public final static Point from(final int position, final Direction direction) {
        return new Point(position, direction);
    }

    public Point(final int position, final Direction direction) {
        validateNegative(position);
        this.position = position;
        this.direction = direction;
    }

    private final void validateNegative(final int position) {
        if (position < ZERO) {
            throw new InputNegativeNumberException(position);
        }
    }

    public final int move() {
        Heading heading = direction.move();
        return heading.go(position);
    }


}
