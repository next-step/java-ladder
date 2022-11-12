package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int MIN_POINT_SIZE = 2;
    // true - false: true
    private final List<Direction> directions;

    public Line(List<Boolean> points) {
        if (points == null || points.size() < MIN_POINT_SIZE) {
            throw new IllegalArgumentException(String.format("한 행의 최소 지점 개수는 %d입니다.", MIN_POINT_SIZE));
        }
        if (points.get(points.size() - 1)) {
            throw new IllegalArgumentException("한 행의 마지막 지점은 사다리를 가질 수 없습니다. 마지막 지점값: " + points.get(points.size() - 1));
        }

        validateContinuousLine(points);

        this.directions = from(points);
    }

    private List<Direction> from(List<Boolean> points) {
        List<Direction> directions = new ArrayList<>();
        boolean isConnected = false;

        for (Boolean point : points) {
            Direction direction = determineDirection(point, isConnected);
            directions.add(direction);
            isConnected = point;
        }

        return directions;
    }

    private Direction determineDirection(boolean point, boolean isConnected) {
        if (point) {
            return Direction.RIGHT;
        }
        if (isConnected) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    public int size() {
        return directions.size();
    }

    public Direction get(int index) {
        return directions.get(index);
    }

    private void validateContinuousLine(List<Boolean> points) {
        for (int i = 1; i < points.size(); ++i) {
            if (points.get(i - 1) && points.get(i - 1) == points.get(i)) {
                throw new IllegalArgumentException("한 행에서 연속된 사다리를 가질 수 없습니다. 입력행: " + points + ", 위치: " + i);
            }
        }
    }
}
