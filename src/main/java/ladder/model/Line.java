package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Line {
    private static final int MIN_POINT_SIZE = 2;
    // true - false: true
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        Objects.requireNonNull(points, "");

        if (points.size() < MIN_POINT_SIZE) {
            throw new IllegalArgumentException(String.format("한 행의 최소 지점 개수는 %d입니다. 입력값: %d", MIN_POINT_SIZE, points.size()));
        }

        if (points.get(points.size() - 1)) {
            throw new IllegalArgumentException("한 행의 마지막 지점은 사다리를 가질 수 없습니다. 마지막 지점값: " + points.get(points.size() - 1));
        }

        validateContinuousLine(points);

        this.points = new ArrayList<>(points);
    }

    public int size() {
        return points.size();
    }

    public boolean getPoint(int index) {
        return points.get(index);
    }

    private void validateContinuousLine(List<Boolean> points) {
        for (int i = 1; i < points.size(); ++i) {
            if (points.get(i - 1) && points.get(i - 1) == points.get(i)) {
                throw new IllegalArgumentException("한 행에서 연속된 사다리를 가질 수 없습니다. 입력행: " + points + ", 위치: " + i);
            }
        }
    }
}
