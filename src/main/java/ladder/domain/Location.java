package ladder.domain;

import java.util.Objects;

public class Location {
    private int location;

    public Location(int firstLocation) {
        this.location = firstLocation;
    }

    public void moveLocation(Line line) {
        boolean left = line.point(location);
        boolean right = false;
        if (location + 1 < line.size()) {
            right = line.point(location + 1);
        }
        move(left, right);
    }

    private void move(boolean left, boolean right) {
        if (left) {
            location--;
        }
        if (right) {
            location++;
        }
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
