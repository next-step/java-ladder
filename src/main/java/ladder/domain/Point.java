package ladder.domain;

import java.text.MessageFormat;
import java.util.Objects;

public class Point {
    private final String name;

    private final Location location;

    private final Location maxLocation;

    public Point(String name, int location, int maxLocation) {
        this(name, new Location(location), new Location(maxLocation));
    }

    private Point(String name, Location location, Location maxLocation) {
        this.name = name;
        this.location = location;
        this.maxLocation = maxLocation;
        validateLocation();
    }
    private void validateLocation() {
        if (location.compareTo(Location.ZERO) < 0 || location.compareTo(maxLocation) >= 0 ) {
            throw new IllegalArgumentException(MessageFormat.format(
                    "위치는 0이상, {0}미만이여야 하니다. 현재 입력합 위치: {1}",
                    maxLocation,
                    location
            ));
        }
    }

    public Point frontPoint() {
        return new Point(this.name, location.frontLocation(), this.maxLocation);
    }

    public Point behindPoint() {
        return new Point(this.name, location.behindLocation(), this.maxLocation);
    }

    public boolean isNameEqual(String targetName) {
        return this.name.equals(targetName);
    }

    public int nameSize() {
        return name.length();
    }

    public String name() {
        return name;
    }

    public boolean isMatch(int location) {
        return this.location.currentLocation() == location;
    }

    public int location() {
        return location.currentLocation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(name, point.name) && Objects.equals(location, point.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    @Override
    public String toString() {
        return "Point{" +
                "name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}
