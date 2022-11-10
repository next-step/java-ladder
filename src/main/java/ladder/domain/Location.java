package ladder.domain;

import java.util.Objects;

public class Location implements Comparable<Location> {
    public static final Location ZERO = new Location(0);
    private final int location;

    public Location(int location) {
        this.location = location;
    }

    public int currentLocation() {
        return location;
    }

    public Location frontLocation() {
        return new Location(location - 1);
    }

    public Location behindLocation() {
        return new Location(location + 1);
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

    @Override
    public String toString() {
        return Integer.toString(location);
    }

    @Override
    public int compareTo(Location o) {
        return Integer.compare(this.location, o.location);
    }
}
