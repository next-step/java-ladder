package nextstep.ladder.domain;

import java.util.Objects;

public class Position {

    private int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(String.format("이 (%d)위치는 음수입니다. 위치는 0이상이어야 합니다.", position));
        }
        this.position = position;
    }

    public boolean isFirstPosition() {
        return position == 0;
    }

    public void crossRight() {
        ++position;
    }

    public void crossLeft() {
        --position;
    }

    public int left() {
        return position - 1;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Position position1 = (Position) object;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
