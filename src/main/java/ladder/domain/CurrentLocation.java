package ladder.domain;

public class CurrentLocation {
    private int location;

    public CurrentLocation(int location) {
        this.location = location;
    }

    public void updateLocation(Direction direction) {
        if (direction.moveLeft()) {
            this.location = location - 1;
        }

        if (direction.moveRight()) {
            this.location = location + 1;
        }
    }

    public int getLocation() {
        return this.location;
    }
}
