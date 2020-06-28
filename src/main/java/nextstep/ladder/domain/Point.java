package nextstep.ladder.domain;

public class Point {

    private final int position;
    private final boolean hasPoint;

    public Point(int position, GenerableStrategy generableStrategy) {
        this.position = position;
        this.hasPoint = generableStrategy.generate();
    }

    private Point(int position) {
        this.position = position;
        this.hasPoint = false;
    }

    public boolean hasPoint() {
        return hasPoint;
    }

    public boolean canBePointInPosition(int currentPosition, Line line) {
        if (!hasPoint) {
            return false;
        }
        if (line.hasPreviousPositionPoint(currentPosition)) {
            return false;
        }
        if (line.hasNextPositionPoint(currentPosition)) {
            return false;
        }
        return true;
    }

    public static Point makePointInLine(int position, Line line,
        GenerableStrategy generableStrategy) {
        Point point = new Point(position, generableStrategy);
        if (point.canBePointInPosition(position, line)) {
            return point;
        }
        return new Point(position);
    }
}
