package ladder.domain;

import java.util.Objects;

public class Position {
    private final int position;

    public Position(final int position) {
        validateNotNegative(position);
        this.position = position;
    }

    private void validateNotNegative(final int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position 값은 음수일 수 없습니다.");
        }
    }

    public Position move(int position) {
        return new Position(this.position + position);
    }

    public int getValue() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
