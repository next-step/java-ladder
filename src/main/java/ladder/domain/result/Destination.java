package ladder.domain.result;

import ladder.domain.common.Point;

import java.util.Objects;

public class Destination {

    private final Prize prize;
    private final Point point;

    public Destination(Prize prize, Point point) {
        this.prize = prize;
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return Objects.equals(prize, that.prize) &&
                Objects.equals(point, that.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize, point);
    }
}