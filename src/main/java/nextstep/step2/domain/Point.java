package nextstep.step2.domain;

import nextstep.step2.vo.Bridge;

import java.util.Objects;

public class Point {
    private final int value;

    private Point(int value) {
        this.value = value;
    }

    public static Point from(int now) {
        return new Point(now);
    }

    public static Point fromWithPoint(Point now) {
        return from(now.value);
    }

    public int getValue() {
        return value;
    }

    public Point movedPoint(Bridge bridge) {
        return from(bridge.movedValue(this.value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point1 = (Point) o;
        return value == point1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
