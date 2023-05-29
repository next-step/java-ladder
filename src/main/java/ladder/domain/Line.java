package ladder.domain;

import ladder.strategy.LineCreateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> points;
    private LineCreateStrategy lineCreateStrategy;

    public Line(int countOfPerson, LineCreateStrategy lineCreateStrategy) {
        this.lineCreateStrategy = lineCreateStrategy;

        List<Boolean> points = createPoints(countOfPerson);
        validatePoints(points);
        this.points = points;
    }

    private List<Boolean> createPoints(int countOfPerson) {

        return lineCreateStrategy.build(countOfPerson);
    }

    private void validatePoints(List<Boolean> points) {
        for (int i = 1; i < points.size(); i++) {
            isThereConsecutiveTrue(points.get(i - 1), points.get(i));
        }
    }

    private void isThereConsecutiveTrue(boolean line1, boolean line2) {
        if (line1 && line2) {
            throw new IllegalStateException("연속된 가로줄은 있을 수 없습니다.");
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public boolean hasLeftPoint(int currentPlayerPoint) {
        if (currentPlayerPoint == 0) {
            return false;
        }
        return points.get(currentPlayerPoint - 1);
    }

    public boolean hasRightPoint(int currentPlayerPoint) {
        if (points.size() == currentPlayerPoint || points.size() < currentPlayerPoint) {
            return false;
        }
        return points.get(currentPlayerPoint);
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }
}
