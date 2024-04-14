package ladder.model;

import java.util.List;
import java.util.stream.IntStream;

import static ladder.model.Point.INVALID_POINT;

public class Line {
    public static final String MISMATCHED_POINT = "유효하지 않은 사다리 데이터 입니다.";

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(List<Point> points) {
        if (isOverlappedLine(points)) {
            throw new IllegalArgumentException(INVALID_POINT);
        }

        if (isMismatchedLine(points)) {
            throw new IllegalArgumentException(MISMATCHED_POINT);
        }
        return new Line(points);
    }

    private static boolean isOverlappedLine(List<Point> points) {
        return IntStream.range(1, points.size())
                .anyMatch(i -> points.get(i - 1).getPoint() && points.get(i).getPoint());
    }

    private static boolean isMismatchedLine(List<Point> points) {
        return IntStream.range(1, points.size())
                .anyMatch(i -> points.get(i - 1).getPoint() != points.get(i).getExPoint());
    }

    public int getSizeOfLine() {
        return points.size();
    }

    public boolean isConnectedToNextLadder(int index) {
        return points.get(index).getPoint();
    }

    protected int moveByDistance(int index) {
        return points.get(index).moveByDistance();
    }
}
