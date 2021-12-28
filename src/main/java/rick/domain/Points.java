package rick.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Points {

    private static final String EXCEPTION_MESSAGE_CAN_NOT_BE_EMPTY = "포인트 목록은 빈 값일 수 없습니다.";
    private static final String EXCEPTION_MESSAGE_CAN_NOT_BE_NULL = "포인트 목록은 null 일 수 없습니다.";
    private static final String EXCEPTION_INTER_POINT_DATA_MISMATCH = "포인터간 데이터가 일치하지 않습니다.";

    private final List<Point> points;

    public Points(List<Point> points) {
        if (Objects.isNull(points)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_CAN_NOT_BE_NULL);
        }

        if (points.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_CAN_NOT_BE_EMPTY);
        }

        if (hasValidatedPoints(points)) {
            throw new IllegalArgumentException(EXCEPTION_INTER_POINT_DATA_MISMATCH);
        }

        this.points = points;
    }

    public boolean movableToLeft(int index) {
        return points.get(index).movableToLeft();
    }

    public boolean movableToRight(int index) {
        return points.get(index).movableToRight();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    private boolean hasValidatedPoints(List<Point> points) {
        boolean invalid = false;
        for (int i = 1; i < points.size() && !invalid; i++) {
            invalid = isInvalid(points.get(i - 1), points.get(i));
        }
        return invalid;
    }

    private boolean isInvalid(Point previousPoint, Point point) {
        return previousPoint.movableToRight() != point.movableToLeft();
    }
}
