package ladder;

import java.util.Objects;

public class SideLine {

    private final Point leftPoint;
    private final Point rightPoint;
    private boolean drawing;

    public static SideLine ofDrawing(Point leftPoint, Point rightPoint) {
        return new SideLine(leftPoint, rightPoint, true);
    }

    public static SideLine ofNotDrawing(Point leftPoint, Point rightPoint) {
        return new SideLine(leftPoint, rightPoint, false);
    }

    private SideLine(Point leftPoint, Point rightPoint, boolean drawing) {
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
        this.drawing = drawing;
    }

    public boolean isDrawing() {
        return this.drawing;
    }

    public Point getLeftPoint() {
        return leftPoint;
    }

    public Point getRightPoint() {
        return rightPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SideLine sideLine = (SideLine) o;
        return Objects.equals(leftPoint, sideLine.leftPoint) &&
                Objects.equals(rightPoint, sideLine.rightPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftPoint, rightPoint);
    }
}
