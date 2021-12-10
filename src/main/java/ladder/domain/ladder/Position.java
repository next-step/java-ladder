package ladder.domain.ladder;

import java.util.Objects;

public class Position {

    public static final int FIRST_POSITION_VALUE = 0;
    public static final String POSITION_ERROR_MSG = "음수값은 안됩니다.";

    private final int position;

    public Position(int position) {
        if (position < FIRST_POSITION_VALUE) {
            throw new IllegalArgumentException(POSITION_ERROR_MSG);
        }
        this.position = position;
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

    @Override
    public String toString() {
        return position + "";
    }

}
