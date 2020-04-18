package ladder.ladder.domain;

import ladder.ladder.infrastructure.RandomLinkStrategy;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private static final int ONE = 1;

    private final List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine of(List<Point> points) {
        return new LadderLine(points);
    }

    public static LadderLine init(int sizeOfPlayer) {
        List<Point> initPoints = new ArrayList<>();
        Point firstPoint = initFirst();
        initPoints.add(firstPoint);

        final int bodySize = sizeOfPlayer - ONE;
        initPoints.addAll(initBody(bodySize, firstPoint));

        Point lastPoint = initLast(initPoints.get(bodySize - ONE));
        initPoints.add(lastPoint);

        return new LadderLine(initPoints);
    }

    private static Point initFirst() {
        return Point.generateFirst(new RandomLinkStrategy().get());
    }

    private static List<Point> initBody(int bodySize, Point point) {
        List<Point> bodyPoints = new ArrayList<>();
        for (int i = 1; i < bodySize; i++) {
            point = point.generateNext(new RandomLinkStrategy());
            bodyPoints.add(point);
        }
        return bodyPoints;
    }

    private static Point initLast(Point point) {
        return point.generateLast();
    }

    public Index move(Index position) {
        int currentIndex = position.getIndex();
        return points.get(currentIndex)
                .move();
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public int size() {
        return points.size();
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }

}
