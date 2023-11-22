package ladder.domain;

import java.util.Objects;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    private Position forward() {
        return new Position(this.position + 1);
    }

    private Position backward() {
        return new Position(this.position - 1);
    }

    public Position moved(Row row) {
        if (canForward(row)) {
            return forward();
        }

        if (canBackward(row)) {
            return backward();
        }

        return this;
    }

    private Boolean canForward(Row row) {
        return !isBoundary(row) && row.movable(this.position);
    }

    private Boolean canBackward(Row row) {
        Position backward = backward();

        return !backward.isBoundary(row) && row.movable(backward.position);
    }

    private boolean isBoundary(Row row) {
        return this.position < 0 || this.position >= row.size();
    }

    public int position() {
        return this.position;
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
