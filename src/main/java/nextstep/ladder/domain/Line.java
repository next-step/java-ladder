package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author han
 */
public class Line {
    private static final int MINIMUM = 2;
    private static final int BASE = 1;

    private final List<Point> points;

    public Line(int users, LineStrategy lineStrategy) {
        if (users < MINIMUM) {
            throw new IllegalArgumentException();
        }
        this.points = createBy(users, lineStrategy);
    }

    private List<Point> createBy(int users, LineStrategy lineStrategy) {
        List<Point> points = new ArrayList<>();
        points.add(Point.init(false));
        IntStream.range(BASE, users)
            .forEach(i -> points.add(points.get(i - BASE).next(lineStrategy)));
        return points;
    }

    public List<Point> getPoints() {
        return points;
    }
}
