package nextstep.ladder.domain;

import java.util.Objects;

public class Location {
    private static final String CREATE_LOCATION_ERROR = "위치는 0보다 큰 값이어야 합니다.";
    private static final int MOVE_UNIT = 1;
    private static final int ZERO_LOCATION = 0;
    private final int location;

    public Location(int location) {
        if (location < ZERO_LOCATION) {
            throw new IllegalArgumentException(CREATE_LOCATION_ERROR);
        }
        this.location = location;
    }

    public Location move(Line line) {
        if (line.valueByLocation(this.location)) {
            return new Location(this.location - MOVE_UNIT);
        }
        if (!line.isSameSize(this.location + MOVE_UNIT) && line.valueByLocation(this.location + MOVE_UNIT)) {
            return new Location(this.location + MOVE_UNIT);
        }
        return this;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location1 = (Location) o;
        return location == location1.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

}
