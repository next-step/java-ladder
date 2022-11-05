package ladder.domain;

import java.util.Objects;

public class Point {
    private final String name;

    private final Location location;

    public Point(String name, int location, int maxLocation) {
        this(name, new Location(location, maxLocation));
    }

    private Point(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public Point movedPoint(Line line){
        if (line.movableToLeft(location.currentLocation())) {
            return new Point(this.name, location.frontLocation());
        }
        if (line.movableToRight(location.currentLocation())) {
            return new Point(this.name, location.behindLocation());
        }
        return this;
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
        return this.location.isMatch(location);
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
