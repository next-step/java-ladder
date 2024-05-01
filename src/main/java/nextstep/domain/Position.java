package nextstep.domain;

import java.util.Objects;

public class Position {
    private Integer position;
    private static final Integer FIRST_POSITION = 0;


    public Position(Integer position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 0보다 작을 수 없습니다.");
        }
        this.position = position;
    }

    public Position move(Line line) {
        if (!Objects.equals(this.position, FIRST_POSITION) && line.hasLine(position - 1)) {
            return new Position(this.position - 1);
        }

        if (!line.isFinalPosition(position) && line.hasLine(position)) {
            return new Position(this.position + 1);
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return Objects.equals(position, position1.position);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }

    public int getPosition() {
        return this.position;
    }
}
