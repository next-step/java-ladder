package nextstep.laddergame.domain;

import java.util.Objects;

public class Cross {
    private final int position;
    private final Point point;

    public Cross(int position, Point leftPoint, boolean current) {
        this.position = position;
        this.point = isFirst(position) ? Point.first(current) : leftPoint.next(current);
    }

    public Cross(int position, Point point) {
        this.position = position;
        this.point = point;
    }

    public static Cross first(boolean point) {
        return new Cross(0, Point.first(point));
    }

    public static Cross last(int position, Boolean left) {
        return new Cross(position, Point.last(left));
    }

    private boolean isFirst(int position) {
        return position == 0;
    }

    public boolean isSet() {
        return point.isSet();
    }

    public Cross next(Boolean next) {
        return new Cross(position + 1, point.next(next));
    }

    public int move() {
        return position + point.resolveMoveDirection().getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cross cross = (Cross) o;
        return position == cross.position && Objects.equals(point, cross.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, point);
    }
}
