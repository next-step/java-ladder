package nextstep.ladder.doamin;

import nextstep.ladder.annotations.GetterForUI;
import nextstep.ladder.doamin.value.Point;
import nextstep.ladder.utils.Preconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Point> points;

    private Line(List<Point> points) {
        Preconditions.checkEmpty(points, "points는 필수값입니다.");

        this.points = points;
    }

    public static Line from(List<Point> points) {
        return new Line(points);
    }

    public Location getCurrentLocation(Location currentLocation) {
        if (isMoveLeft(currentLocation)) {
            return currentLocation.decreaseLocation();
        }

        if (isMoveRight(currentLocation)) {
            return currentLocation.increaseLocation();
        }

        return currentLocation;
    }

    private boolean isMoveLeft(Location currentLocation) {
        return currentLocation.isMoveLeft(points);
    }

    private boolean isMoveRight(Location currentLocation) {
        return currentLocation.isMoveRight(points);
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
