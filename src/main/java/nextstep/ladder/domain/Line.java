package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final int FIRST_INDEX = 1;

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public List<Point> getLine() {
        return Collections.unmodifiableList(points);
    }

    public static Line of(int width, LineStrategy lineStrategy) {
        Point point = Point.first(lineStrategy.draw());
        List<Point> points = new ArrayList<>();
        points.add(point);
        IntStream.range(FIRST_INDEX, width - 1)
                .forEach(index -> {
                    Point prevPoint = points.get(points.size() -1);
                    points.add(prevPoint.next(lineStrategy.draw()));
                });
        Point prevPoint = points.get(points.size() -1);
        points.add(prevPoint.last());
        return new Line(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }
}
