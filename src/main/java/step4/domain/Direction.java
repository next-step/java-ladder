package step4.domain;

public enum Direction {
    LEFT(-1),
    DOWN(0),
    RIGHT(1);

    public final int value;

    Direction(int value) {
        this.value = value;
    }
}
