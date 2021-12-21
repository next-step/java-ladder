package nextstep.ladder.domain;

public enum Direction {
    LEFT(false, -1),
    BYPASS(false, 0),
    RIGHT(true, 1);

    private final boolean point;
    private final int diff;

    Direction(boolean point, int diff) {
        this.point = point;
        this.diff = diff;
    }

    public static Direction of(boolean first, boolean second) {
        if (first && second) {
            throw new IllegalStateException();
        }

        return first ? LEFT : second ? RIGHT : BYPASS;
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    public Direction next(boolean next) {
        return of(this.point, next);
    }

    public Direction last() {
        return of(this.point, false);
    }

    public int diff() {
        return diff;
    }
}
