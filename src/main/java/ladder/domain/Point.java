package ladder.domain;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.RIGHT;

import java.util.Objects;

public class Point {

    private final static String ERROR_EMPTY_VALUE = "입력 값이 누락되었습니다.";
    private final static int LEFT_VALUE = -1;
    private final static int RIGHT_VALUE = 1;

    private final PositiveInt index;

    public Point(final PositiveInt index) {
        this.index = index;
    }

    public int getIndex() {
        return index.getValue();
    }

    public Point move(final Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }

        if (direction == LEFT) {
            return new Point(index.plus(LEFT_VALUE));
        }

        if (direction == RIGHT) {
            return new Point(index.plus(RIGHT_VALUE));
        }

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Point)) {
            return false;
        }

        return this.index.equals(((Point) o).index);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.index);
    }
}
