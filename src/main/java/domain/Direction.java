package domain;

public enum Direction {
    NONE, LEFT, RIGHT;

    public static Direction nextDirection(boolean movable) {
        return movable ? RIGHT : NONE;
    }
}
