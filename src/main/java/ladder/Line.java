package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Line {
    private static final Random random = new Random();

    private List<Point> points = new ArrayList<>();


    public Line(int countOfPerson) {
        boolean lastConnected = false;
        for (int i = 0; i < countOfPerson; i ++) {
            boolean nextConnected = !lastConnected && randomBoolean();
            lastConnected = nextConnected;
            points.add(new Point(nextConnected));
        }
    }

    public List<Point> getPoints() {
        return points;
    }

    private boolean randomBoolean() {
        return random.nextBoolean();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
