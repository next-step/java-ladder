package ladder.Model;

public enum Direction {
    DOWN(0),
    LEFT(-1),
    RIGHT(1);

    private final int index;

    Direction(int index) {
        this.index = index;
    }

    public int of() {
        return index;
    }
}
