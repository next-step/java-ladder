package ladder.domain;

import java.util.List;

import ladder.exception.LineInvalidException;
import ladder.strategy.LineCreationStrategy;
import ladder.strategy.LineRandomStrategy;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfPersons) {
        this(countOfPersons, new LineRandomStrategy());
    }

    Line(int countOfPersons, LineCreationStrategy strategy) {
        List<Boolean> points = strategy.hasHorizontalLine(countOfPersons);
        validatePoints(points);
        this.points = strategy.hasHorizontalLine(countOfPersons);
    }

    private void validatePoints(List<Boolean> points) {
        for (int i = 0; i < points.size() - 1; i++) {
            validatePoint(points.get(i), points.get(i + 1));
        }
    }

    private static void validatePoint(boolean prevPoint, boolean currentPoint) {
        if (prevPoint && currentPoint) {
            throw new LineInvalidException();
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
