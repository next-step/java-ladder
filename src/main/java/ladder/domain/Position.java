package ladder.domain;

import java.util.Objects;

public class Position {

    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public Position move(Line line) {
        if (line.canMoveRight(this.position)) {
            return new Position(this.position + 1);
        }

        if (line.canMoveLeft(this.position)) {
            return new Position(this.position - 1);
        }

        return this;
    }

    public int getPosition() {
        return position;
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
