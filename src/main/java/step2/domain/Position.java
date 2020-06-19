package step2.domain;

import java.util.Objects;

public class Position {
    private static final int INCREASE_ONE = 1;
    private static final int POSITION_ZERO = 0;
    public static final String POSITION_EXCEPTION = "위치값은 음수가 될 수 없습니다.";

    private int position;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < POSITION_ZERO){
            throw new IllegalArgumentException(POSITION_EXCEPTION);
        }
    }

    public Position increase() {
        return new Position(position + INCREASE_ONE);
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

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }
}
