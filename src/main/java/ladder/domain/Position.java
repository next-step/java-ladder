package ladder.domain;

import java.util.Objects;

public class Position {
    private static final int MIN_VALUE = 0;
    private static final String POINT_ERROR_MESSAGE = "위치는 " + MIN_VALUE + "보다 작을 수 없습니다.";

    private final int position;

    public Position(String position) {
        this(Integer.parseInt(position));
    }

    public Position(int position) {
        validateValue(position);
        this.position = position;
    }

    private void validateValue(int position) {
        if (position < MIN_VALUE) {
            throw new IllegalArgumentException(POINT_ERROR_MESSAGE);
        }
    }

    public int getPosition() {
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

}
