package nextstep.ladder.domain;

public class Point {

    private final int index;
    private final PointState pointState;

    public Point(int index, boolean hasLine, Point previousPoint) {
        this(index, new PointState(hasLine, previousPoint.pointState));
    }

    public Point(int index, PointState pointState) {
        this.index = index;
        this.pointState = pointState;
    }

    public static Point createFirst() {
        return new Point(0, PointState.createForFirst());
    }

    public Point createNext() {
        if (pointState.hasLine()) {
            return createNoLine();
        }
        return new Point(index + 1, pointState.createNextState());
    }

    public Point createNoLine() {
        return new Point(index + 1, pointState.createNextStateWithNoLine());
    }

    public boolean hasLine() {
        return pointState.hasLine();
    }

    public int move() {
        if (pointState.canMovePrevious()) {
            return index - 1;
        }

        if (pointState.canMoveNext()) {
            return index + 1;
        }

        return index;
    }
}
