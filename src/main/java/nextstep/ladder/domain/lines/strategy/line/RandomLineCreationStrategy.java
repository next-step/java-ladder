package nextstep.ladder.domain.lines.strategy.line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.lines.strategy.point.PointCreationStrategy;

public class RandomLineCreationStrategy implements LineCreationStrategy {

    private final PointCreationStrategy pointCreationStrategy;

    public RandomLineCreationStrategy(PointCreationStrategy pointCreationStrategy) {
        this.pointCreationStrategy = pointCreationStrategy;
    }

    @Override
    public Line createNextLine(Line beforeLine, int height) {
        return Line.createLineWithPoints(createNextPoints(beforeLine, height, pointCreationStrategy));
    }

    private List<Point> createNextPoints(Line beforeLine, int height, PointCreationStrategy pointCreationStrategy) {
        if (beforeLine.isEmptyLine()) {
            return createFirstPoints(height, pointCreationStrategy);
        }
        return createOtherPoints(beforeLine, height, pointCreationStrategy);
    }

    private List<Point> createFirstPoints(int height, PointCreationStrategy pointCreationStrategy) {
        return IntStream.range(0, height)
                .mapToObj(currentHeight -> pointCreationStrategy.createNextPoint(Point.NOTHING))
                .collect(Collectors.toList());
    }

    private List<Point> createOtherPoints(Line beforeLine, int height, PointCreationStrategy pointCreationStrategy) {
        return IntStream.range(0, height)
                .mapToObj(beforeLine::horizontalLine)
                .map(pointCreationStrategy::createNextPoint)
                .collect(Collectors.toList());
    }
}
