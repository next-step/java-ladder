package nextstep.ladder.domain.edge;

import nextstep.ladder.domain.line.Line;

import java.util.Objects;

public class Position {
    private final int value;

    public Position(int start) {
        if (start < 0) {
            throw new IllegalArgumentException("위치 값은 0 이하가 될 수 없습니다.");
        }
        this.value = start;
    }

    public int getValue() {
        return value;
    }

    public boolean canMoveLeft(Line line) {
        return value > 0 && line.get(value - 1).getValue();
    }

    public boolean canMoveRight(Line line) {
        return value < line.size() && line.get(value).getValue();
    }

    public Position moveLeft() {
        return new Position(value - 1);
    }

    public Position moveRight() {
        return new Position(value + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Position{" +
            "value=" + value +
            '}';
    }
}
