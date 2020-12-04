package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private static final AtomicReference<Boolean> PREVIOUS = new AtomicReference<>(false);
    private final List<Point> points;

    public Line (int countOfPerson) {
        this.points = generateLine(countOfPerson);
    }

    public Line (List<Point> points) {
        this.points = points;
    }

    private static List<Point> generateLine(int countOfPerson) {
        List<Point> points = IntStream.rangeClosed(1,countOfPerson - 1)
                .mapToObj(position -> compareAndSet(Point.shuffle()))
                .collect(Collectors.toList());
        points.add(Point.of(false));
        return points;
    }

    private static Point compareAndSet(Point point) {
        if (PREVIOUS.compareAndSet(false, point.isMovable())) {
            return point;
        }
        PREVIOUS.set(false);
        return Point.of(false);
    }

    public boolean hasRightMoved(int index) {
        if (index == (points.size() - 1)) {
            return false;
        }
        return points.get(index).isMovable();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
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
}
