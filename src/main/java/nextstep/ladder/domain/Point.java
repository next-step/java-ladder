package nextstep.ladder.domain;

public class Point {

    private final boolean hasLadder;

    private Point(boolean hasLadder) {
        this.hasLadder = hasLadder;
    }

    boolean isValid(Point pre) {
        if (!hasLadder) {
            return true;
        }

        return !pre.hasLadder;
    }

    boolean hasLadder() {
        return this.hasLadder;
    }

    static Point of(boolean hasLadder) {
        return new Point(hasLadder);
    }
}
