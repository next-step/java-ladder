package nextstep.ladder.doamin.value;

import nextstep.ladder.utils.Preconditions;

import java.util.Objects;

public class Point {
    private final Boolean point;

    public Point(Boolean point) {
        Preconditions.checkNotNull(point, "point는 필수값입니다.");

        this.point = point;
    }

    public static Point from(Boolean point) {
        return new Point(point);
    }

    public Boolean isTrue() {
        return Boolean.TRUE.equals(point);
    }

    public Boolean isFalse() {
        return Boolean.FALSE.equals(point);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point1 = (Point) o;
        return Objects.equals(point, point1.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
