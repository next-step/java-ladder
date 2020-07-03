package ladder.domain;

public class Point {
    private final int index;
    private Point nextMovePoint;

    public Point(int index) {
        this.index = index;
    }

    public int getPointIndex() {
        return index;
    }

    public Point getNextMovePoint() {
        return nextMovePoint;
    }

    public int getNextMovePointIndex() {
        return nextMovePoint.getPointIndex();
    }

    public void setNextMovePoint(final Point nextMovePoint) {
        this.nextMovePoint = nextMovePoint;
    }

    public boolean isBiggerIndexThan(final Point point) {
        return index > point.getPointIndex();
    }

}
