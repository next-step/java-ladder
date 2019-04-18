package domain;

public enum DirectionEnum {
    NONE, LEFT, RIGHT;

    public static DirectionEnum nextDirection(boolean movable) {
        return movable ? RIGHT : NONE;
    }

//    public static DirectionEnum first(boolean b) {
//    }
}
