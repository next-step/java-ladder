package nextstep.refactoring.ladder.engine;

import java.util.Objects;

public class Position {

    private final int index;

    private Position(int index) {
        this.index = index;
    }

    public static Position of(int index) {
        validate(index);
        return new Position(index);
    }

    private static void validate(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
        }
    }

    public Position getLeft() {
        return Position.of(index - 1);
    }

    public Position getRight() {
        return Position.of(index + 1);
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return index == position.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
