package ladder.domain;

import java.util.Objects;

public class Position {
    public static final String POSITION_EXCEPTION = "위치값은 음수가 될 수 없습니다.";

    private static final int INCREASE = 1;
    private static final int INIT_POSITION = 0;

    private int position;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < INIT_POSITION){
            throw new IllegalArgumentException(POSITION_EXCEPTION);
        }
    }

    public Position increase() {
        return new Position(position + INCREASE);
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
