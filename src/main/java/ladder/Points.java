package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Points {
    private static final Random random = new Random();

    private List<Point> points = new ArrayList<>();

    public Points(int count) {
        boolean lastConnected = false;
        for (int i = 0; i < count; i ++) {
            boolean nextConnected = !lastConnected && randomBoolean();
            lastConnected = nextConnected;
            points.add(new Point(nextConnected));
        }
    }

    public Points(List<Point> points) {
        this.points = points;
    }

    private boolean randomBoolean() {
        return random.nextBoolean();
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
