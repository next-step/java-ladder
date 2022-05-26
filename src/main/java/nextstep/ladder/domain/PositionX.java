package nextstep.ladder.domain;

import java.util.Objects;

public class PositionX {
    private int x;

    public PositionX(int x) {
        this.x = x;
    }

    public void increase(Points points) {
        if (this.x == 0 && points.firstMatch()) {
            increase();
            return;
        }

        if (points.sameSize(x) && points.lastMatch()) {
            increase();
            return;
        }

        if (points.anyBesideMatch(x)) {
            increase();
        }
    }

    private synchronized void increase() {
        this.x++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionX positionX = (PositionX) o;
        return x == positionX.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }
}
