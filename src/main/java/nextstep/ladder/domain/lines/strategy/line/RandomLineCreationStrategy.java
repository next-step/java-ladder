package nextstep.ladder.domain.lines.strategy.line;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.lines.strategy.point.RandomPointsFactory;

public class RandomLineCreationStrategy implements LineCreationStrategy {

    private final RandomPointsFactory randomPointsFactory;

    public RandomLineCreationStrategy(RandomPointsFactory randomPointsFactory) {
        this.randomPointsFactory = randomPointsFactory;
    }

    @Override
    public Line createNextLine(Line beforeLine, int height) {
        return Line.createLineWithPoints(randomPointsFactory.createNextPoints(beforeLine, height));
    }
}
