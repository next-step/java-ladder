package step2.domain;

import java.util.Objects;

public class Position {
    public static final int START_POSITION = 0;
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position of(int position) {
        return new Position(position);
    }

    public int position() {
        return position;
    }

    public void moveFront() {
        position++;
    }

    public void moveBack() {
        validateMoveBackPosition();
        position--;
    }

    public boolean startingPosition() {
        return position == START_POSITION;
    }

    private void validateMoveBackPosition() {
        if (startingPosition()) {
            throw new IllegalArgumentException("위치가 0에서 뒤로 이동할 수 없습니다.");
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
