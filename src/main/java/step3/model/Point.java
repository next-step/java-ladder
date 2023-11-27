package step3.model;

public class Point {

    private boolean status;

    public Point(boolean status) {
        this.status = status;
    }

    public Point() {
    }

    public Point create(Point point, RandomStrategy randomStrategy) {
        if (point == null || !point.status) {
            return new Point(randomStrategy.hasPoint());
        }

        return new Point(false);
    }

    public boolean getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        if (this.status) {
            return Ladder.LINE_WITH_POINTS.getShape();
        }

        return Ladder.LINE_ONLY.getShape();
    }
}
