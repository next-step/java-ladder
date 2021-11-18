package nextstep.ladder.doamin;

import nextstep.ladder.annotations.GetterForUI;
import nextstep.ladder.doamin.value.Location;
import nextstep.ladder.doamin.value.Point;
import nextstep.ladder.utils.Preconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final String INVALID_LOCATION = "Location 값이 잘못되었습니다.";
    private final List<Point> points;

    private Line(List<Point> points) {
        Preconditions.checkEmpty(points, "points는 필수값입니다.");

        this.points = points;
    }

    public static Line from(List<Point> points) {
        return new Line(points);
    }

    public Location getCurrentLocation(Location location) {
        if (isMoveLeft(location)) {
            return location.decreaseLocation();
        }

        if (isMoveRight(location)) {
            return location.increaseLocation();
        }

        return location;
    }

    private boolean isMoveLeft(Location location) {
        if (location.isFirstPoint()) {
            return false;
        }
        validateLeftLocation(location);

        return points.get(location.getCurrentLocation()).isTrue()
                && points.get(location.getPreviousLocation()).isFalse();
    }

    private boolean isMoveRight(Location location) {
        if (location.isLastPoint(points.size() - 1)) {
            return false;
        }
        validateRightLocation(location);

        return points.get(location.getCurrentLocation()).isFalse()
                && points.get(location.getNextLocation()).isTrue();
    }

    private void validateLeftLocation(Location location) {
        if (points.get(location.getCurrentLocation()).isTrue()
                && points.get(location.getPreviousLocation()).isTrue()) {
            throw new IllegalArgumentException(INVALID_LOCATION);
        }
    }

    private void validateRightLocation(Location location) {
        if (points.get(location.getCurrentLocation()).isTrue()
                && points.get(location.getNextLocation()).isTrue()) {
            throw new IllegalArgumentException(INVALID_LOCATION);
        }
    }

    @GetterForUI
    public List<Point> getPoints() {
        return Collections.unmodifiableList(new ArrayList<>(points));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
