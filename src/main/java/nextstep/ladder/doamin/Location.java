package nextstep.ladder.doamin;

import nextstep.ladder.annotations.GetterForUI;
import nextstep.ladder.doamin.value.Point;
import nextstep.ladder.utils.Preconditions;

import java.util.List;
import java.util.Objects;

public class Location {
    private static final Integer START_LOCATION = 0;
    private static final Integer PREVIOUS_LOCATION = -1;
    private static final Integer NEXT_LOCATION = 1;

    private final Integer currentLocation;

    private Location(Integer currentLocation) {
        Preconditions.checkNotNull(currentLocation, "currentLocation는 필수값입니다.");

        this.currentLocation = currentLocation;
    }

    public static Location from(Integer currentLocation) {
        return new Location(currentLocation);
    }

    public Location increaseLocation() {
        return new Location(currentLocation + NEXT_LOCATION);
    }

    public Location decreaseLocation() {
        return new Location(currentLocation + PREVIOUS_LOCATION);
    }

    public boolean isMoveLeft(List<Point> points) {
        Preconditions.checkEmpty(points, "points는 필수값입니다.");

        if (START_LOCATION.equals(currentLocation)) {
            return false;
        }
        return points.get(currentLocation).isTrue() && points.get(currentLocation + PREVIOUS_LOCATION).isFalse();
    }

    public boolean isMoveRight(List<Point> points) {
        Preconditions.checkEmpty(points, "points는 필수값입니다.");

        if (currentLocation == points.size() - 1) {
            return false;
        }
        return points.get(currentLocation).isFalse() && points.get(currentLocation + NEXT_LOCATION).isTrue();
    }

    @GetterForUI
    public Integer getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(this.currentLocation, location.currentLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentLocation);
    }
}
