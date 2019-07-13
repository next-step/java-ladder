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
        makeStartPoint(randomStrategy, points);
        makeMidPoints(randomStrategy, countOfUsers, points);
        makeEndPoint(points);
        return new LadderLine(points);
    }

    private static void makeStartPoint(RandomStrategy randomStrategy, List<Point> points) {
        points.add(Point.ofStart(randomStrategy));
    }

    private static void makeMidPoints(RandomStrategy randomStrategy, PositiveNumber countOfUsers, List<Point> points) {
        long maxOfIndex = countOfUsers.get() - 1;
        Point point = getLastPoint(points);
        for (int i = 1; i < maxOfIndex; i++) {
            point = point.next(randomStrategy);
            points.add(point);
        }
    }

    private static void makeEndPoint(List<Point> points) {
        points.add(getLastPoint(points).ofEnd());
    }

    private static Point getLastPoint(List<Point> points) {
        return points.get(points.size() - 1);
    }

    public List<Point> get() {
        return Collections.unmodifiableList(points);
    }

    Index move(Index index) {
        return findPoint(index).move();
    }

    private Point findPoint(Index index) {
        return points.stream()
                .filter(point -> point.isSamePoint(index))
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
