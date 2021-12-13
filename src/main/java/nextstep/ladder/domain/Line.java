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
        List<Point> points = new ArrayList<>();
        points.add(new Point(false));
        IntStream.range(FIRST_INDEX, width)
                .forEach(index -> {
                    int prevIndex = index - 1;
                    Point prevPoint = points.get(prevIndex);
                    points.add(createPoint(prevPoint, lineStrategy));
                });
        return new Line(points);
    }

    private static Point createPoint(Point prev, LineStrategy lineStrategy) {
        if (prev.isValue()) {
            return new Point(false);
        }
        return new Point(lineStrategy.draw());
    }
}
