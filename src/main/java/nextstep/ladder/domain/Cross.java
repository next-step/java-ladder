package nextstep.ladder.domain;

public class Cross {
    private final int position; //height
    private final Point point;

    private Cross(int position, Point point) {
        this.position = position;
        this.point = point;
    }

    public static Cross first(boolean right) {
        return new Cross(0, Point.first(right));
    }

    public Cross next(boolean right) {
        return new Cross(this.position + 1, point.next(right));
    }

    public Cross last() {
        return new Cross(this.position + 1, point.last());
    }

    public int move() {
        return position + point.move().move();
    }

    public boolean hasRightConnection() {
        return point.hasRightConnection();
    }
}
