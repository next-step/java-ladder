package ladder;

import java.util.*;

public class Points {
    private static final Random random = new Random();

    private List<Point> points = new ArrayList<>();

    public Points(int count) {
        for (int i = 0; i < count; i++) {
            addPoint();
        }
    }

    public Points(List<Point> points) {
        this.points = points;
    }

    private static boolean randomBoolean() {
        return random.nextBoolean();
    }

    private void addPoint() {
        points.add(new Point(connectable()));
    }

    private boolean connectable() {
        if (points.isEmpty()) return randomBoolean();
        if (points.stream().allMatch(point -> !point.connected())) return true;

        return !lastConnected() && randomBoolean();
    }

    private boolean lastConnected() {
        return points.get(points.size() - 1).connected();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points1 = (Points) o;
        return Objects.equals(points, points1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Points{" +
                "points=" + points +
                '}';
    }
}
