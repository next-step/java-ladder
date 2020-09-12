package step04.model;

public class DirectionPoint {

    private Point leftPoint;
    private Point rightPoint;

    private DirectionPoint(Point leftPoint, Point rightPoint) {
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
    }

    public static DirectionPoint of(Point leftPoint, Point rightPoint) {
        return new DirectionPoint(leftPoint, rightPoint);
    }

    public boolean isLeft() {
        return leftPoint == Point.ROW;
    }

    public boolean isRight() {
        return rightPoint == Point.ROW;
    }

    @Override
    public String toString() {
        return leftPoint.getPrintableString()
                + Point.COLUMN.getPrintableString();
    }
}
