package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Points {
    private final List<Point> points;

    private Points(final List<Point> points) {
        this.points = points;
    }

    public static Points of(final Length width) {
        List<Point> points = new ArrayList<>();
        for(int i = 0; i < width.getValue() - 1; i++) {
            Point point = isFormerPointPresent(points, i) ? new Point(false) : new Point();
            points.add(point);
        }

        return new Points(points);
    }

    private static boolean isFormerPointPresent(final List<Point> points, final int index) {
        return index != 0 && points.get(index-1).isPresent();
    }

    public Stream<Point> stream() {
        return points.stream();
    }
}
