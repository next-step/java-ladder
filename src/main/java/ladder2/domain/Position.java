package ladder2.domain;

import java.util.Objects;

public class Position {

    private static final String NEGATIVE_EXCEPTION_MESSAGE = "음수가 될 수 없습니다";
    
    private final int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(NEGATIVE_EXCEPTION_MESSAGE);
        }
        this.position = position;
    }

    public Position plus() {
        return new Position(position + 1);
    }

    public Position minus() {
        return new Position(position - 1);
    }

    public int value() {
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
