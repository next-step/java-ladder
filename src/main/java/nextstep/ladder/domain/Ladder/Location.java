package nextstep.ladder.domain.Ladder;

import java.util.Objects;

public class Location {
    private static final int MOVEMENT_UNIT = 1;
    private final int location;

    public static Location from(final int location) {
        return new Location(location);
    }

    private Location(final int location) {
        if (location < 0) {
            throw new IllegalArgumentException("위치 값은 음수가 될 수 없습니다.");
        }
        this.location = location;
    }

    public Location toRight() {
        return from(location + MOVEMENT_UNIT);
    }

    public Location toLeft() {
        return from(location - MOVEMENT_UNIT);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        final Location location1 = (Location) o;
        return location == location1.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
