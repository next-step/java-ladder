package step2.model;

public class Point {

    private boolean point = false;

    public Point(boolean point) {
        this.point = point;
    }

    public Point() {
    }

    public Point create(Point point, RandomStrategy randomStrategy) {
        if (point != null && !point.point) {
            return new Point(randomStrategy.hasPoint());
        }

        return new Point(false);
    }

    @Override
    public String toString() {
        if (this.point) {
            return "-----|";
        }

        return "     |";
    }
}
