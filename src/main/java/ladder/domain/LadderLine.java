package ladder.domain;

import java.util.List;

public class LadderLine {
    private final List<Boolean> points;

    public LadderLine(List<Boolean> points) {
        this.points = points;
    }

    public int move(int startPosition) {
        if (startPosition < 0 || startPosition > points.size()) {
            throw new IllegalArgumentException("Invalid start position");
        }

        if (isRightConnected(startPosition)) return startPosition + 1;
        if (isLeftConnected(startPosition)) return startPosition - 1;

        return startPosition;
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

    private boolean isLeftConnected(int startPosition) {
        if (startPosition == 0) {
            return false;
        }

        return points.get(startPosition - 1);
    }

    private boolean isRightConnected(int startPosition) {
        if (startPosition == points.size()) {
            return false;
        }

        return points.get(startPosition);
    }
}
