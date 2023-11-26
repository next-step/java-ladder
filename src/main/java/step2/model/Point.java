package step2.model;

public class Point {

    private boolean status = false;

    public Point(boolean status) {
        this.status = status;
    }

    public Point() {
    }

    public Point create(Point point, RandomStrategy randomStrategy) {
        if (point != null && !point.status) {
            return new Point(randomStrategy.hasPoint());
        }

        return new Point(false);
    }

    @Override
    public String toString() {
        if (this.status) {
            return "-----|";
        }

        return "     |";
    }
}
