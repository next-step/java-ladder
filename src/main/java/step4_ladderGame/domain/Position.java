package step4_ladderGame.domain;

import java.util.Objects;

public class Position {

    private final int position;

    private Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("포지션은 0이상이여야 합니다.");
        }
        this.position = position;
    }

    public static Position of(int position) {
        return new Position(position);
    }

    public Position right() {
        return new Position(position + 1);
    }

    public Position left() {
        return new Position(position - 1);
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
    
    public int toInt() {
        return position;
    }

    public int compare(Position otherPosition) {
        return position - otherPosition.position;
    }
}
