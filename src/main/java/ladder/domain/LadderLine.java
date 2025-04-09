package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public class LadderLine {
    private final List<Boolean> points;

    public LadderLine(List<Boolean> points) {
        if (!isValid(points)) {
            throw new IllegalArgumentException("Invalid points");
        }
        this.points = points;
    }

    public Position move(Position startPosition) {
        validatePosition(startPosition);

        if (isRightConnected(startPosition.value())) return startPosition.add(1);
        if (isLeftConnected(startPosition.value())) return startPosition.subtract(1);

        return startPosition;
    }

    private void validatePosition(Position startPosition) {
        if (startPosition == null) {
            throw new IllegalArgumentException("Start position cannot be null");
        }

        if (startPosition.value() > points.size()) {
            throw new IllegalArgumentException("Start position out of bounds");
        }
    }

    public int size() {
        return points.size();
    }

    public boolean getPoint(int index) {
        if (index < 0 || index >= points.size()) {
            throw new IllegalArgumentException("Invalid index");
        }
        return points.get(index);
    }

    private boolean isValid(List<Boolean> points) {
        return !isEmpty(points) && IntStream.range(0, points.size() - 1)
                .noneMatch(i -> points.get(i) && points.get(i + 1));
    }

    private boolean isEmpty(List<Boolean> points) {
        return points == null || points.isEmpty();
    }

    private boolean isLeftConnected(int startPosition) {
        return startPosition > 0 && points.get(startPosition - 1);
    }

    private boolean isRightConnected(int startPosition) {
        return startPosition < points.size() && points.get(startPosition);
    }

    public LadderLine copy() {
        List<Boolean> copiedPoints = List.copyOf(points);
        return new LadderLine(copiedPoints);
    }
}
