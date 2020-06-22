package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        if (points.isEmpty()) {
            this.points = Collections.emptyList();
            return;
        }

        validateNotConnectFirst(points);

        validateNotConnectSeries(points);

        this.points = points;
    }

    private void validateNotConnectFirst(List<Boolean> points) {
        if (points.get(0)) {
            throw new IllegalArgumentException("Ladders cannot be connected first");
        }
    }

    private void validateNotConnectSeries(List<Boolean> points) {
        points.stream()
                .reduce((b1, b2) -> {
                    if (b1 && b2) {
                        throw new IllegalArgumentException("Ladders cannot be connected in series");
                    }
                    return b2;
                });
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public Direction getDirection(int x) {
        if (points.get(x)) {
            return Direction.LEFT;
        }
        if (x + 1 < points.size() && points.get(x + 1)) {
            return Direction.RIGHT;
        }
        return Direction.CENTER;
    }
}
