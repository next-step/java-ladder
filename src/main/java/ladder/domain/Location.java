package ladder.domain;

public class Location {
    private int location;

    public Location(int firstLocation) {
        this.location = firstLocation;
    }

    public void moveLocation(Line line) {
        boolean left = line.getPoints().get(location);
        boolean right = false;
        if (location + 1 < line.getPoints().size()) {
            right = line.getPoints().get(location + 1);
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
}
