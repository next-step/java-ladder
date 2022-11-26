package nextstep.ladder.domain;

public class Cross {
    private final int position;
    private final Point point;

    public Cross(final int position, final Point point) {
        this.position = position;
        this.point = point;
    }

    public Cross next(final Movable movable) {
        return new Cross(position + 1, point.next(movable));
    }

    public Cross next(final boolean right) {
        return new Cross(position + 1, point.next(right));
    }

    public static Cross first(final boolean right) {
        return new Cross(0, Point.first(right));
    }

    /**
     * 마지막 point(people - 1) 직전인지 check 하기 위해 people -2로 검사
     * @param people
     */
    public boolean untilBeforeLastPoint(final int people) {
        return position < people - 2;
    }

    public Cross last() {
        return new Cross(position + 1, point.last());
    }

    public int move() {
        return point.move().movePosition(this.position);
    }

    public Point getPoint() {
        return point;
    }
}
