package ladder.domain;

import java.text.MessageFormat;
import java.util.Objects;

public class Location {

    private final int location;

    private final int maxLocation;

    public Location(int location, int maxLocation) {
        this.location = location;
        this.maxLocation = maxLocation;
        validateLocation();
    }

    public int currentLocation() {
        return location;
    }

    public Location frontLocation() {
        return new Location(location - 1, this.maxLocation);
    }

    public Location behindLocation() {
        return new Location(location + 1, this.maxLocation);
    }

    public boolean isMatch(int location) {
        return location == this.location;
    }

    private void validateLocation() {
        if (location < 0 || location >= maxLocation) {
            throw new IllegalArgumentException(MessageFormat.format(
                    "위치는 0이상, {0}미만이여야 하니다. 현재 입력합 위치: {1}",
                    maxLocation,
                    location
            ));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location1 = (Location) o;
        return location == location1.location && maxLocation == location1.maxLocation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, maxLocation);
    }

    @Override
    public String toString() {
        return "Location{" +
                "location=" + location +
                '}';
    }
}
