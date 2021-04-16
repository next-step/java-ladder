package nextstep.ladder.domain;

import nextstep.ladder.strategy.DirectionStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CrossingPoints {
    private final List<CrossingPoint> crossingPoints;

    public CrossingPoints(int countOfPlayer, DirectionStrategy directionStrategy) {
        this(new CountOfPlayer(countOfPlayer), directionStrategy);
    }

    public CrossingPoints(CountOfPlayer countOfPlayer, DirectionStrategy directionStrategy) {
        this(createWith(countOfPlayer, directionStrategy));
    }

    public CrossingPoints(List<CrossingPoint> crossingPoints) {
        this.crossingPoints = crossingPoints;
    }

    private static List<CrossingPoint> createWith(CountOfPlayer countOfPlayer, DirectionStrategy directionStrategy) {
        List<CrossingPoint> crossingPoints = new ArrayList<>(countOfPlayer.number());
        CrossingPoint crossingPoint = CrossingPoint.first(directionStrategy);
        crossingPoints.add(crossingPoint);

        while (crossingPoint.isNotLast(countOfPlayer.number())) {
            crossingPoint = crossingPoint.next(directionStrategy);
            crossingPoints.add(crossingPoint);
        }

        crossingPoints.add(crossingPoint.last());

        return crossingPoints;
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
