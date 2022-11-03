package ladder.domain;

import java.text.MessageFormat;
import java.util.Objects;

public class Point {
    private final String name;

    private final int location;

    private final int maxLocation;

    public Point(String name, int location, int maxLocation) {
        this.name = name;
        this.location = location;
        this.maxLocation = maxLocation;
        validateLocation();
    }

    public Point movedPoint(Line line){
        if (line.isRightEdge(location) && line.isRoadExist(location)) {
            return this.moveRight();
        }
        if (line.isLeftEdge(location - 1) && line.isRoadExist(location - 1)) {
            return this.moveLeft();
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
        return location == this.location;
    }

    public int location() {
        return location;
    }

    private Point moveLeft() {
        return new Point(this.name, this.location - 1, this.maxLocation);
    }

    private Point moveRight() {
        return new Point(this.name, this.location + 1, this.maxLocation);
    }

    private void validateLocation() {
        if (location < 0 || location >= maxLocation) {
            throw new IllegalArgumentException(MessageFormat.format(
                    "위치는 0이상, {0}미만이여야 하니다. 햔제 입력합 위치: {1}",
                    maxLocation,
                    location
            ));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return location == point.location && maxLocation == point.maxLocation && Objects.equals(name, point.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, maxLocation);
    }

    @Override
    public String toString() {
        return "Point{" +
                "name='" + name + '\'' +
                ", location=" + location +
                ", maxLocation=" + maxLocation +
                '}';
    }
}
