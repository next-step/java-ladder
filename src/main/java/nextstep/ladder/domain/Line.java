package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Line implements Iterable<Point> {
    private final List<Point> points;

    private Line(final List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public static Line from(final List<Point> points) {
        return new Line(points);
    }

    public Stream<Point> stream() {
        return points.stream();
    }

    @Override
    public Iterator<Point> iterator() {
        return points.iterator();
    }

    @Override
    public void forEach(final Consumer<? super Point> action) {
        points.forEach(action);
    }

    @Override
    public Spliterator<Point> spliterator() {
        return points.spliterator();
    }
}
