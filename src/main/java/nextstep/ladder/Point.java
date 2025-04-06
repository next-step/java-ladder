package nextstep.ladder;

public enum Point {
    LEFT,
    RIGHT,
    NONE,
    ;

    public static Point get(PointGetStrategy pointGetStrategy) {
        return pointGetStrategy.getPoint();
    }
}
