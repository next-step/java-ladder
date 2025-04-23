package nextstep.ladder.domain;

import java.util.*;

public class LadderLine {
    public static final String INVALID_LINE_SIZE_MESSAGE = "사다리 라인의 크기는 1 이상이어야 합니다.";

    private final List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public List<Point> asList() {
        return points;
    }

    public int nextPosition(int position) {
        return points.get(position).move(position);
    }

    public static LadderLine generate(int width, ConnectionStrategy connectionStrategy) {
        validSize(width);

        List<Point> points = new ArrayList<>();
        Point prevPoint = Point.first(connectionStrategy.connect());
        points.add(prevPoint);
        for (int i = 1; i < width - 1; i++) {
            Point nextPoint = prevPoint.next(connectionStrategy);
            points.add(nextPoint);
            prevPoint = nextPoint;
        }
        points.add(prevPoint.last());

        return new LadderLine(points);
    }

    private static void validSize(int width) {
        if (width < 2) {
            throw new IllegalArgumentException(INVALID_LINE_SIZE_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
