package rick.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import rick.strategy.LineCreationStrategy;

public class Line {

    private static final String EXCEPTION_MESSAGE_CAN_NOT_BE_EMPTY = "포인트 목록은 빈 값일 수 없습니다.";
    private static final String EXCEPTION_MESSAGE_CAN_NOT_BE_NULL = "포인트 목록은 null 일 수 없습니다.";
    private static final String EXCEPTION_MESSAGE_CAN_NOT_BE_CONSECUTIVE = "라인은 연속되는 이동가능한 포인터를 가질 수 없습니다.";

    private final List<Point> points;

    public Line(int countOfPerson, LineCreationStrategy pointsGenerationStrategy) {
        this(pointsGenerationStrategy.create(countOfPerson - 1));
    }

    public Line(List<Point> points) {
        if (Objects.isNull(points)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_CAN_NOT_BE_NULL);
        }

        if (points.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_CAN_NOT_BE_EMPTY);
        }

        if (hasConsecutivePoints(points)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_CAN_NOT_BE_CONSECUTIVE);
        }

        this.points = points;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    private boolean hasConsecutivePoints(List<Point> points) {
        boolean isConsecutivePoints = false;
        for (int i = 1; i < points.size() && !isConsecutivePoints; i++) {
            isConsecutivePoints = isConsecutiveMovablePoints(points.get(i - 1), points.get(i));
        }
        return isConsecutivePoints;
    }

    private boolean isConsecutiveMovablePoints(Point previousPoint, Point point) {
        return previousPoint.movable() && previousPoint.equals(point);
    }

    public int nextPlayerIndex(int playerIndex) {
        int leftPointIndex = playerIndex - 1;
        int rightPointIndex = playerIndex;

        if (leftPointIndex >= 0 && movable(leftPointIndex)) {
            return --playerIndex;
        }

        if (rightPointIndex < points.size() && movable(rightPointIndex)) {
            return ++playerIndex;
        }

        return playerIndex;
    }

    private boolean movable(int pointIndex) {
        return points.get(pointIndex).movable();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
