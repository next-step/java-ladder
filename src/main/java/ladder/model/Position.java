package ladder.model;

import java.util.Objects;

public class Position {

    private static final int FIRST_POSITION = 0;

    private final int position;

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < FIRST_POSITION) {
            throw new IllegalArgumentException("위치는 음수일 수 없습니다.");
        }
    }

    public static Position first() {
        return new Position(FIRST_POSITION);
    }

    public Position goNext() {
        return new Position(position + 1);
    }

    public Position goBack() {
        return new Position(position - 1);
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
