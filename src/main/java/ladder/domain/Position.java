package ladder.domain;

import java.util.Objects;
import java.util.function.IntPredicate;

public class Position {

    private final int index;

    public Position(int index) {
        this.index = index;
    }

    public Position moveLeft() {
        return new Position(index - 1);
    }

    public Position moveRight() {
        return new Position(index + 1);
    }

    public Position move(IntPredicate predicate) {
        if (predicate.test(this.index)) {
            return moveRight();
        }

        if (predicate.test(this.index - 1)) {
            return moveLeft();
        }

        return this;
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
