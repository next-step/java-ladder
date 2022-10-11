package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Point {

    public static final int DEFAULT_POSITION = 1;
    private static final String INVALID_POSITION_EXCEPTION_MESSAGE = "위치는 1 이상이어야 합니다.";

    private final int position;
    private final boolean enable;

    public static Point of(int position, PointEnableStrategy pointEnableStrategy) {
        return new Point(position, pointEnableStrategy.isEnable());
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

    public boolean isEnable() {
        return enable;
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
