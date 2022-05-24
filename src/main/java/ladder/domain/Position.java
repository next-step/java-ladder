package ladder.domain;

import java.util.Objects;

public class Position {
    private int position;

    private Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("좌표값의 위치는 0보다 작을 수 없습니다.");
        }
        this.position = position;
    }

    public static Position from(int position) {
        return new Position(position);
    }

    public int now() {
        return this.position;
    }

    public int backward() {
        return this.position - 1;
    }

    public int forward() {
        return this.position + 1;
    }

    public Position movedBackward() {
        return Position.from(this.position - 1);
    }

    public Position movedForward() {
        return Position.from(this.position + 1);
    }

    public boolean isFirst() {
        return this.position == 0;
    }

    public boolean isLast(int lastPosition) {
        return this.position == lastPosition;
    }

    public boolean isOver(int lastPosition) {
        return this.position > lastPosition;
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
