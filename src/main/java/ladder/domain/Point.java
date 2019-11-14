package ladder.domain;

public class Point {

    private final LadderPoint ladderPoint;
    private static Point previousHorizontalPoint = null;

    private Point(LadderPoint ladderPoint) {
        this.ladderPoint = ladderPoint;
    }

    private static Point setHorizontalState(Point horizontalLadderPoint) {
        return previousHorizontalPoint = horizontalLadderPoint;
    }

    public static Point of(LadderPoint ladderPoint) {
        return new Point(ladderPoint);
    }

    public static Point ofRandomHorizontal(HorizontalPointGeneratorPolicy horizontalPointGeneratorPolicy) {
        return setHorizontalState(new Point(horizontalPointGeneratorPolicy.getResult() ? LadderPoint.CONNECTED_POINT : LadderPoint.EMPTY_POINT));
    }

    public static Point ofVertical() {
        return new Point(LadderPoint.VERTICAL_POINT);
    }

    public static Point ofEmptyHorizontal() {
        return setHorizontalState(new Point(LadderPoint.EMPTY_POINT));
    }

    public static Point ofOrder(int order) {
        if (order % 2 == 0) {
            return Point.ofVertical();
        }
        return generateStatefulHorizontalPoint(new RandomHorizontalPointGeneratorPolicy());
    }

    static Point generateStatefulHorizontalPoint(HorizontalPointGeneratorPolicy horizontalPointGeneratorPolicy) {
        if (previousHorizontalPoint == null || !previousHorizontalPoint.isConnected()) {
            return Point.ofRandomHorizontal(horizontalPointGeneratorPolicy);
        }
        return Point.ofEmptyHorizontal();
    }

    public boolean isConnected() {
        return ladderPoint == LadderPoint.CONNECTED_POINT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point point = (Point) o;

        return ladderPoint == point.ladderPoint;
    }

    @Override
    public int hashCode() {
        return ladderPoint != null ? ladderPoint.hashCode() : 0;
    }

    @Override
    public String toString() {
        return ladderPoint.toString();
    }
}
