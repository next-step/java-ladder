package ladder.domain;

import java.util.Objects;

public class Position {

    private final int index;

    private Position(int index) {
        this.index = index;
    }

    public static Position of(int index) {
        return new Position(index);
    }

    @Override
    public String toString() {
        return String.valueOf(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return index == position.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

    public Position next(HorizonLine horizonLine) {
        if(horizonLine.isEnabledShortLineOfLeft(index)) {
            return left();
        }
        if(horizonLine.isEnabledShortLineOfRight(index)) {
            return right();
        }
        return this;
    }

    private Position left() {
        return Position.of(index - 1);
    }

    private Position right() {
        return Position.of(index + 1);
    }

    public int get() {
        return index;
    }
}
