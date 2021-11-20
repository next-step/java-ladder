package nextstep.ladder.doamin.value;

import nextstep.ladder.utils.Preconditions;

import java.util.Objects;

public class Location {
    private static final Integer PREVIOUS_LOCATION = -1;
    private static final Integer NEXT_LOCATION = 1;
    private static final Integer FIRST_LOCATION = 0;

    private final Integer location;

    private Location(Integer location) {
        Preconditions.checkNotNull(location, "location는 필수값입니다.");

        this.location = location;
    }

    public static Location from(Integer currentLocation) {
        return new Location(currentLocation);
    }

    public Location increaseLocation() {
        return new Location(location + NEXT_LOCATION);
    }

    public Location decreaseLocation() {
        return new Location(location + PREVIOUS_LOCATION);
    }

    public boolean isFirstPoint() {
        return location.equals(FIRST_LOCATION);
    }

    public boolean isLastPoint(Integer lastLocation) {
        return location.equals(lastLocation);
    }

    public Integer getPreviousLocation() {
        return location + PREVIOUS_LOCATION;
    }

    public Integer getNextLocation() {
        return location + NEXT_LOCATION;
    }

    public Integer getCurrentLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location1 = (Location) o;
        return Objects.equals(location, location1.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
