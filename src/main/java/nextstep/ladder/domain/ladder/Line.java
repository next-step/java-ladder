package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static nextstep.ladder.domain.ladder.Point.DEFAULT_POSITION;

public class Line {
    private final List<Point> points;

    public static Line create(int countOfPlayer, PointEnableStrategy strategy) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(DEFAULT_POSITION, strategy.isEnable()));

        IntStream.range(DEFAULT_POSITION, DEFAULT_POSITION + countOfPlayer)
                .forEach(i -> addNewPoint(points, i, strategy));

        return new Line(points);
    }

    private static void addNewPoint(List<Point> points, int index, PointEnableStrategy strategy) {
        if (isPreviousPointEnable(points, index)) {
            points.add(Point.of(index, () -> false));
            return;
        }

        points.add(Point.of(index, strategy));
    }

    private static boolean isPreviousPointEnable(List<Point> points, int index) {
        return points.get(index - 1).isEnable();
    }

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Point> points() {
        return Collections.unmodifiableList(points);
    }
}
