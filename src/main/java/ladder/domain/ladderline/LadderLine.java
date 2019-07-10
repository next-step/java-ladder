package ladder.domain.ladderline;

import ladder.common.PositiveNumber;
import ladder.common.RandomStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLine {
    private List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    static LadderLine of(RandomStrategy randomStrategy, PositiveNumber countOfUsers) {
        List<Point> points = new ArrayList<>();
        Point point = makeStartPoint(randomStrategy, points);
        point = makeMidPoints(randomStrategy, points, countOfUsers, point);
        makeEndPoint(points, point);
        return new LadderLine(points);
    }

    private static Point makeStartPoint(RandomStrategy randomStrategy, List<Point> points) {
        Point point = Point.ofStart(randomStrategy);
        points.add(point);
        return point;
    }

    private static Point makeMidPoints(RandomStrategy randomStrategy, List<Point> points, PositiveNumber countOfUsers, Point point) {
        for (int i = 1; i < countOfUsers.get() - 1; i++) {
            point = point.next(randomStrategy);
            points.add(point);
        }

        return point;
    }

    private static void makeEndPoint(List<Point> points, Point point) {
        point = point.ofEnd();
        points.add(point);
    }

    public List<Point> get() {
        return Collections.unmodifiableList(points);
    }

    Index move(Index index) {
        return findPoint(index).move();
    }

    private Point findPoint(Index index) {
        return points.stream()
                .filter(point -> point.current().equals(index))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Abnormal ladder line"));
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
