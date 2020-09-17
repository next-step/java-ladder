package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {

    public static final int COUNT_MIN = 2;

    private final List<Point> points = new ArrayList<>();
    private final int maxOfPoints;

    private Line(int maxOfPoints) {
        this.maxOfPoints = maxOfPoints;
    }

    public static Line of(int maxOfPoints) {
        validateCount(maxOfPoints);
        return new Line(maxOfPoints);
    }

    private static void validateCount(int maxOfPoints) {
        if (maxOfPoints < COUNT_MIN) {
            throw new IllegalArgumentException("최소한의 다리를 생성할 수 없습니다.");
        }
    }

    public boolean add(Point newPoint) {
        if (isFull()) {
            return false;
        }
        if (!points.isEmpty()) {
            validateConnection(newPoint);
        }
        return points.add(newPoint);
    }

    private boolean isFull() {
        return points.size() == maxOfPoints;
    }

    private void validateConnection(Point newPoint) {
        Point lastPoint = points.get(points.size() - 1);
        if (lastPoint.checkConnected(newPoint)) {
            throw new IllegalArgumentException("가로 라인은 연속적으로 연결될 수 없습니다.");
        }
    }
}
