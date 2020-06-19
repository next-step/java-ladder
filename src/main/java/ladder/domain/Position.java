package ladder.domain;

import java.util.Objects;

public class Position {

    private int index;

    public Position(int index) {
        this.index = index;
    }

    public void moveLeft() {
        this.index--;
    }

    public void moveRight() {
        this.index++;
    }

    public int getIndex() {
        return index;
    }

    public static Position of(int index) {
        return new Position(index);
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
}
