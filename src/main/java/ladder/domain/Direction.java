package ladder.domain;

public enum Direction {

    LEFT(-1),
    RIGHT(1),
    NONE(0);

    int index;

    Direction(int index) {
        this.index = index;
    }

    public int move() {
        return index;
    }
}
