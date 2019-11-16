package nextstep.ladder.domain;

import java.util.Objects;

public class Point {

    private final int order;
    private final Status status;

    private Point(int order, Status status) {
        this.order = order;
        this.status = status;
    }

    public static Point ofFirst(boolean start) {
        return new Point(0, Status.ofFisrt(start));
    }

    public Point createNext(boolean next) {
        return new Point(order + 1, status.createNext(next));
    }

    public Point createLast() {
        return new Point(order + 1, status.createLast());
    }

    public int move() {
        return order + status.move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return order == point.order &&
                Objects.equals(status, point.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, status);
    }
}
