package ladder.domain;

import java.util.Objects;

public class Position {
    private final int position;

    public static Position of(int input) {
        return new Position(input);
    }

    private Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(String.format("Position은 음수(%d)일 수 없습니다.", position));
        }
        this.position = position;
    }

    Position forward() {
        return new Position(position + 1);
    }

    Position back() {
        return new Position(position - 1);
    }

    boolean goe(int input) {
        return position >= input;
    }

    int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
