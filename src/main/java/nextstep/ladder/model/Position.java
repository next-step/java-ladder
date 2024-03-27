package nextstep.ladder.model;

import java.util.Objects;

public class Position {
    private int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("음수 값은 허용하지 않습니다");
        }

        this.position = position;
    }

    public boolean greaterThan(int other) {
        return this.position > other;
    }

    public boolean lessThan(int other) {
        return this.position < other;
    }

    public void moveLeft() {
        if (this.position <= 0) {
            throw new IllegalArgumentException("왼쪽으로 이동할 수 없습니다");
        }

        this.position -= 1;
    }

    public void moveRight() {
        this.position += 1;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Position position1 = (Position) other;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
