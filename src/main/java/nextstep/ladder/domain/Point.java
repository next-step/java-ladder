package nextstep.ladder.domain;

public class Point {

    private boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    public boolean isTrue() {
        return this.point;
    }

    public boolean isFalse() {
        return !this.point;
    }
}
