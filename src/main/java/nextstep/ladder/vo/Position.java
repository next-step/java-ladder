package nextstep.ladder.vo;

import java.util.Objects;

public class Position {
    private final int position;

    public Position(int position) {
        validatePosition(position);

        this.position = position;
    }

    private void validatePosition(int stepPosition) {
        if (isNegative(stepPosition)) {
            throw new IllegalArgumentException("위치는 음수 일수 없습니다.");
        }
    }

    private boolean isNegative(int position) {
        return position < 0;
    }

    public int getPosition() {
        return position;
    }

    public boolean isEqualPosition(int position) {
        return this.position == position;
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
