package ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class HorizontalLine implements Iterable<Point> {

    private static final int LAST_LINE = 1;
    private static final int SECOND_LINE = 1;

    private final List<Point> points;

    public HorizontalLine(List<Point> points) {
        this.points = points;
    }

    public static HorizontalLine create(int countOfPerson, LineStrategy lineStrategy) {
        List<Point> points = new ArrayList<>(List.of(Point.createFirst(lineStrategy)));

        IntStream.range(SECOND_LINE, countOfPerson - LAST_LINE)
            .forEach(i -> points.add(getLastPoint(points).createNext(lineStrategy)));

        points.add(getLastPoint(points).createLast());

        return new HorizontalLine(points);
    }

    private static Point getLastPoint(List<Point> points) {
        return points.get(points.size() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HorizontalLine that = (HorizontalLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public Iterator<Point> iterator() {
        return points.iterator();
    }

}
