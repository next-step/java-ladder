package ladder;

public class SideLine {

    private final Point leftPoint;
    private final Point rightPoint;

    public SideLine(Point leftPoint, Point rightPoint) {
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
    }

    public Point getLeftPoint() {
        return leftPoint;
    }

    public Point getRightPoint() {
        return rightPoint;
    }
}
