package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Point {

    public static final int DEFAULT_POSITION = 1;
    private static final String INVALID_POSITION_EXCEPTION_MESSAGE = "위치는 1 이상이어야 합니다.";

    private final int position;
    private final boolean enable;

    public static Point of(int position, EnablePointStrategy enablePointStrategy) {
        return new Point(position, enablePointStrategy.isEnable());
    }

    public Point(int position, boolean enable) {
        validate(position);

        this.position = position;
        this.enable = enable;
    }

    private void validate(int position) {
        if (position < DEFAULT_POSITION) {
            throw new IllegalArgumentException(INVALID_POSITION_EXCEPTION_MESSAGE);
        }
    }

    public int position() {
        return position;
    }

    public boolean isEnable() {
        return enable;
    }

    public boolean isConnected(Point nextPoint) {
        return isNext(nextPoint) && this.enable && nextPoint.enable;
    }

    private boolean isNext(Point nextPoint) {
        return Math.abs(this.position - nextPoint.position) == 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return position == point.position && enable == point.enable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, enable);
    }
}
