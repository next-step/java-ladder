package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CrossingPoints {
    private final List<CrossingPoint> crossingPoints;

    public CrossingPoints(List<CrossingPoint> crossingPoints) {
        this.crossingPoints = crossingPoints;
    }

    public List<CrossingPoint> crossingPoints() {
        return Collections.unmodifiableList(crossingPoints);
    }

    public int move(int index) {
        return crossingPoints.get(index).move();
    }

    public List<Boolean> pointsConnection() {
        return this.crossingPoints.stream()
                .map(CrossingPoint::point)
                .map(Point::hasRightDirection)
                .limit(crossingPoints().size() - 1)
                .collect(Collectors.toList());
    }
}
