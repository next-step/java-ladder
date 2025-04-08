package nextstep.ladder.domain;

public class Point {
    private final boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    public boolean isPresent() {
        return point;
    }
}
