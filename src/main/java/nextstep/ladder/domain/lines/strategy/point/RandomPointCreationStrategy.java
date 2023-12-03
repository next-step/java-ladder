package nextstep.ladder.domain.lines.strategy.point;

import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.lines.RandomService;

public class RandomPointCreationStrategy implements PointCreationStrategy {
    private final RandomService randomService;

    public RandomPointCreationStrategy(RandomService randomService) {
        this.randomService = randomService;
    }

    @Override
    public Point createNextPoint(Point beforePoint) {
        return beforePoint.createNonOverlappingPoint(randomService.nextBoolean());
    }
}
