package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineBuilder {

    private static final Random RANDOM = new Random();

    private final List<Point> points = new ArrayList<>();

    public static Line buildWithRandomPoints(int count) {
        return new LineBuilder().initRandomMoveablePoint()
                .addRandomMoveablePoints(count - 2)
                .build();
    }

    private LineBuilder addPoint(Point point) {
        points.add(point);
        return this;
    }

    private Line build() {
        points.add(Point.rightmostPoint(lastPoint().canMoveLeft()));
        return new Line(points);
    }

    private LineBuilder addRandomMoveablePoints(int countOfMiddlePoint) {
        points.addAll(generateMiddlePoints(countOfMiddlePoint));
        return this;
    }

    private LineBuilder initRandomMoveablePoint() {
        return addPoint(Point.leftmostPoint(RANDOM.nextBoolean()));
    }

    private List<Point> generateMiddlePoints(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> generateMiddlePoint())
                .collect(Collectors.toList());
    }

    private Point generateMiddlePoint() {
        boolean leftMoveable = lastPoint().canMoveRight();
        boolean rightMoveable = !leftMoveable && RANDOM.nextBoolean();
        return new Point(leftMoveable, rightMoveable);
    }

    private Point lastPoint() {
        return points.get(points.size() - 1);
    }
}
