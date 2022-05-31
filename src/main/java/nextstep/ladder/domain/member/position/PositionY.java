package nextstep.ladder.domain.member.position;

import java.util.Objects;

public class PositionY {
    private int y;

    public PositionY(int y) {
        this.y = y;
    }

    public void increase() {
        this.y++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionY positionY = (PositionY) o;
        return y == positionY.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y);
    }
}
