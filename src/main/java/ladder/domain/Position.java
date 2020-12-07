package ladder.domain;

import java.util.Objects;
import ladder.exception.LadderGameException;

public class Position {

    public static final Position LINE_START_POSITION = new Position(0);
    private static final Position POSITION_ONE = new Position(1);
    private static final String PLEASE_INPUT_OVER_OR_EQUAL_MIN = "%d 보다 작은 수를 좌표 값으로 설정할 수 없습니다.";
    private static final int MIN_POSITION = 0;

    public final int position;

    public Position(int position) {
        if(position < MIN_POSITION) {
            throw new LadderGameException(String.format(PLEASE_INPUT_OVER_OR_EQUAL_MIN, MIN_POSITION));
        }
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Position decreasePosition() {
        return new Position(this.position - POSITION_ONE.position);
    }

    public Position increasePosition() {
        return new Position(this.position + POSITION_ONE.position);
    }

    public Position keepPosition() {
        return this;
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