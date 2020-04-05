package Ladder.domain;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    private Line(final List<Boolean> points) {
        validateLine(points);
        this.points = points;
    }

    public static Line of(final List<Boolean> points) {
        return new Line(points);
    }

    private void validateLine(final List<Boolean> points) {
        final int size = points.size();
        for (int i = 1; i < size; i++) {
            checkPointAvailable(points, i);
        }
    }

    private void checkPointAvailable(final List<Boolean> points, final int index) {
        if (points.get(index) && points.get(index - 1)) {
            throw new IllegalArgumentException("Not allow continuous horizontal movement Index : " + index);
        }
    }

    public int getLineSize() {
        return this.points.size();
    }

    public boolean getPoint(final int index) {
        return this.points.get(index);
    }
}
