package nextstep.ladder;

public class Position {
    private Location index;
    private Location height;

    public Position(int index, Location height) {
        this.index = new Location(index);
        this.height = height;
    }

    public Position(int index, int height) {
        this.index = new Location(index);
        this.height = new Location(height);
    }

    public void move(Direction direction) {
        this.index.move(direction.getValue());
        this.height.move(1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return index.equals(position.index) && height.equals(position.height);
    }

    @Override
    public String toString() {
        return "Position{" +
                "index=" + index +
                ", height=" + height +
                '}';
    }
}
