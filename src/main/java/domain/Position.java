package domain;

import java.util.Objects;

public class Position {

    private final int x;
    private final int y;

    public Position(int x, int y) {
        validatePositive(x, y);
        this.x = x;
        this.y = y;
    }

    public static Position from(Position position) {
        return new Position(position.x, position.y);
    }

    private void validatePositive(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("좌표는 음수일 수 없습니다.");
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
