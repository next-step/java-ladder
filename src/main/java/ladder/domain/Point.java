package ladder.domain;

import java.util.Objects;

public class Point {

    private final static String ERROR_EMPTY_VALUE = "입력 값이 누락되었습니다.";

    private final PositiveInt index;

    public Point(final PositiveInt index) {
        this.index = index;
    }

    public Point(final int index) {
        this.index = new PositiveInt(index);
    }

    public Point move(final Direction direction) {
        validate(direction);
        return direction.move(index);
    }

    private void validate(final Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }
    }

    public PositiveInt getIndex() {
        return index;
    }

    public int getIndexValue() {
        return index.getValue();
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
