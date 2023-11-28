package ladder.domain;

import java.util.Objects;

public class Location {

    private static final Location POSITIVE = new Location(true);
    private static final Location NEGATIVE = new Location(false);
    private final boolean value;

    public Location(boolean value) {
        this.value = value;
    }

    public static Location valueOf(boolean value) {
        if (value) {
            return POSITIVE;
        }
        return NEGATIVE;
    }

    public boolean exist() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return value == location.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
