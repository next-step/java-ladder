package step4.domain;

import java.util.Objects;

public class Position {
    private static final int START_POSITION = 0;

    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position of(int position) {
        return new Position(position);
    }

    public Position next() {
        return of(position + 1);
    }

    public void moveLeft() {
        validateMovableToLeft();
        position--;
    }

    public void moveRight() {
        position++;
    }

    public int position() {
        return position;
    }

    private void validateMovableToLeft() {
        if (position == START_POSITION) {
            throw new IllegalArgumentException("위치 0에서 왼쪽으로 이동할 수 없습니다.");
        }
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
}
