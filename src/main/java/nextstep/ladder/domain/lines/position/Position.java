package nextstep.ladder.domain.lines.position;

import java.util.Objects;

public class Position {

    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public boolean isSame(int size) {
        return this.position == size;
    }

    public int calculateMinusPosition() {
        return this.position - 1;
    }

    public Position leftPosition() {
        return new Position(this.position - 1);
    }

    public int getBeforePosition(int size) {
        if (this.position == 0 || this.position > size) {
            return 0;
        }
        return this.position - 1;
    }

    public Position moveByDirection(int direction) {
        return new Position(this.position + direction);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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


