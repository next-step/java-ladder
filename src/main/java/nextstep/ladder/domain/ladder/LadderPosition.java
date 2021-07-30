package nextstep.ladder.domain.ladder;

import nextstep.ladder.exception.OutOfRangeArgumentException;

import java.util.Objects;

public class LadderPosition {
    private static final int ZERO = 0;

    private int position;

    private LadderPosition(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < ZERO) {
            throw OutOfRangeArgumentException.greaterThan(ZERO, position);
        }
    }

    public static LadderPosition from(int position) {
        return new LadderPosition(position);
    }

    public LadderPosition moveLeft() {
        return new LadderPosition(position - 1);
    }

    public LadderPosition moveRight() {
        return new LadderPosition(position + 1);
    }

    public int toInt() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderPosition that = (LadderPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
