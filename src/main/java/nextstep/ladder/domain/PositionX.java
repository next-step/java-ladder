package nextstep.ladder.domain;

import java.util.Objects;

public class PositionX {
    private int x;

    public PositionX(int x) {
        this.x = x;
    }

    public void increaseOrDecrease(Points points) {
        if (this.x == 0) {
            if (points.firstMatch()) {
                increase();
            }
            return;
        }

        if (points.sameSize(x)) {
            if (points.lastMatch()) {
                decrease();
            }
            return;
        }

        if (points.leftMatch(x)) {
            decrease();
            return ;
        }

        if (points.rightMatch(x)) {
            increase();
        }
    }

    private synchronized void decrease() {
        this.x--;
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
