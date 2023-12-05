package ladder.domain;


import java.util.List;

public class Row {

    private final List<Point> points;

    private Row(List<Point> points) {
        this.points = points;
    }

    public static Row from(List<Point> points) {
        return new Row(points);
    }

    public int move(int position) {
        Point point = points.get(position);
        return point.move(position);
    }

    public int size() {
        return points.size();
    }

    public List<Point> values() {
        return points;
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
