package step4.domain;

import java.util.Objects;

import step4.exception.NaturalNumberException;

public class Position {
    private final int position;

    private Position(int position) {
        validate(position);
        this.position = position;
    }

    public static Position valueOf(int position) {
        return new Position(position);
    }

    private void validate(int position) {
        if (position < 0) {
            throw new NaturalNumberException("유효하지 않은 라인 번호 입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Position position1 = (Position)o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
