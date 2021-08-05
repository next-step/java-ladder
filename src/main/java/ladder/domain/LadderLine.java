package ladder.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine implements Iterable<Point> {
    private final List<Point> points;

    public LadderLine(final List<Point> points) {
        this.points = points;
    }

    public static LadderLine generate(final int size) {
        List<Point> points =
                Stream.iterate(Point.first(), Point::next)
                        .limit(size)
                        .collect(Collectors.toList());

        return new LadderLine(points);
    }


    public int move(final int index) {
        Point point = findByIndex(index)
                .orElseThrow(IndexOutOfBoundsException::new);

        return point.move(index);
    }

    private Optional<Point> findByIndex(final int index) {
        return points.stream()
                .filter(iPoint -> iPoint.checkIndex(index))
                .findFirst();
    }

    public int size() {
        return points.size();
    }

    @Override
    public Iterator<Point> iterator() {
        return points.iterator();
    }
}
