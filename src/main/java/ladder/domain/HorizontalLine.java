package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HorizontalLine {

    private final List<Point> points;

    public HorizontalLine(List<Point> points) {
        this.points = points;
    }

    public HorizontalLine(Boolean... points) {
        this(Arrays.stream(points).map(Point::new).collect(Collectors.toList()));
    }

    public List<Point> points() {
        return points;
    }

    public int move(int position) {
        if (isAbleToGoToTheRight(position)) {
            return Direction.RIGHT.apply(position);
        }
        if (isAbleToGoToTheLeft(position)) {
            return Direction.LEFT.apply(position);
        }
        return position;
    }

    private boolean isAbleToGoToTheRight(int position) {
        if (isRightEnd(position)) {
            return false;
        }
        return isExistRightLine(position);
    }

    private boolean isExistRightLine(int position) {
        return points.get(position).isTrue();
    }

    private boolean isRightEnd(int position) {
        return position == points.size();
    }

    private boolean isAbleToGoToTheLeft(int position) {
        if (isLeftEnd(position)) {
            return false;
        }
        return isExistLeftLine(position);
    }

    private boolean isExistLeftLine(int position) {
        return points.get(position - 1).isTrue();
    }

    private boolean isLeftEnd(int position) {
        return position - 1 < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HorizontalLine)) {
            return false;
        }
        HorizontalLine that = (HorizontalLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
