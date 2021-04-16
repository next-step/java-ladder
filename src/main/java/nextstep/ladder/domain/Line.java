package nextstep.ladder.domain;

import nextstep.ladder.strategy.DirectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final CrossingPoints crossingPoints;

    public Line(int countOfPlayer, DirectionStrategy directionStrategy) {
        this(new CountOfPlayer(countOfPlayer), directionStrategy);
    }

    public Line(CountOfPlayer countOfPlayer, DirectionStrategy directionStrategy) {
        this(createWith(countOfPlayer, directionStrategy));
    }

    private static CrossingPoints createWith(CountOfPlayer countOfPlayer, DirectionStrategy directionStrategy) {
        List<CrossingPoint> crossingPoints = new ArrayList<>(countOfPlayer.number());
        CrossingPoint crossingPoint = CrossingPoint.first(directionStrategy);
        crossingPoints.add(crossingPoint);

        while (crossingPoint.isNotLast(countOfPlayer.number())) {
            crossingPoint = crossingPoint.next(directionStrategy);
            crossingPoints.add(crossingPoint);
        }

        crossingPoints.add(crossingPoint.last());

        return new CrossingPoints(crossingPoints);
    }

    public Line(CrossingPoints crossingPoints) {
        this.crossingPoints = crossingPoints;
    }

    public int move(int index) {
        return crossingPoints.move(index);
    }

    public CrossingPoints crossingPoints() {
        return crossingPoints;
    }
}