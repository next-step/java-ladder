package domain;

public enum Direction {

    LEFT,
    PASS,
    RIGHT;

    public boolean isSame(Direction direction) {
        return this == direction;
    }
}
