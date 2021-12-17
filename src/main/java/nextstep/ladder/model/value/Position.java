package nextstep.ladder.model.value;

import nextstep.ladder.service.CustomException;

import java.util.Objects;

public class Position {

    private final int UNIT = 1;
    private final int MIN_NUMBER = 0;

    private final String MINUS_ERROR_MSG = "음수의 위치는 생성할 수 없습니다!!!";

    private final int position;

    public Position(int position) {

        if(position < MIN_NUMBER) {
            throw new CustomException(MINUS_ERROR_MSG);
        }

        this.position = position;
    }

    public Position move(Line line) {
        if (line.hasLeftLine(position).isTrue()) {
            return new Position(position - UNIT);
        }

        if (line.hasRightLine(position).isTrue()) {
            return new Position(position + UNIT);
        }

        return this;
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
        return UNIT == position1.UNIT && position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(UNIT, position);
    }
}
