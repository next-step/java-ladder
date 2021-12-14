package ladder.domain.ladder;

import java.util.Objects;

public class PointPosition {

    public static final int FIRST_POSITION_VALUE = 0;
    public static final String ERROR_POSITION_VALUE_MSG = "음수값은 안됩니다.";

    private int position;

    public PointPosition(int position) {
        if (position < FIRST_POSITION_VALUE) {
            throw new IllegalArgumentException(ERROR_POSITION_VALUE_MSG);
        }
        this.position = position;
    }

    public int increment() {
        return ++position;
    }

    public int decrement() {
        return --position;
    }

    public int stop() {
        return position;
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
        PointPosition position = (PointPosition) o;
        return this.position == position.position;
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
