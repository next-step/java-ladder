package ladder.domain;

public class Point {

    private boolean point;

    public Point(boolean value) {
        this.point = value;
    }

    public boolean isPoint() {
        return point;
    }

    @Override
    public String toString() {
        if (this.point) {
            return "-----|";
        }
        return "     |";
    }
}