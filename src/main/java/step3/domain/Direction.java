package step3.domain;

public enum Direction {
    LEFT,
    RIGHT,
    SKIP;

    public boolean isDirection(Direction direction) {
        return this == direction;
    }
}
