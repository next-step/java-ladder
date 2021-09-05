package step4.ladderGame.domain.ladder;

import step4.ladderGame.domain.ladder.GenerateDirectionStrategy.GenerateDirectionStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public final class LadderLine {

    private final List<Point> points;

    private LadderLine(final List<Point> points) {
        this.points = points;
    }

    public int move(final int position) {
        return points.get(position).move();
    }

    public static LadderLine init(final int sizeOfPerson, final GenerateDirectionStrategy generateDirectionStrategy) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, generateDirectionStrategy);
        point = initBody(sizeOfPerson, points, point, generateDirectionStrategy);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initBody(final int sizeOfPerson, final List<Point> points, Point point, final GenerateDirectionStrategy generateDirectionStrategy) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(generateDirectionStrategy);
            points.add(point);
        }

        return point;
    }

    private static void initLast(final List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(final List<Point> points, final GenerateDirectionStrategy generateDirectionStrategy) {
        Point point = Point.first(generateDirectionStrategy);
        points.add(point);
        return point;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public Stream<Point> stream() {
        return points.stream();
    }

}
