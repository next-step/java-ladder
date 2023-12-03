package nextstep.ladder.domain.lines.strategy.point;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;

public class RandomPointsFactory {

    private final PointCreationStrategy pointCreationStrategy;

    public RandomPointsFactory(PointCreationStrategy pointCreationStrategy) {
        this.pointCreationStrategy = pointCreationStrategy;
    }

    public List<Point> createNextPoints(Line beforeLine, int height) {
        if (beforeLine.isEmptyLine()) {
            return createFirstPoints(height);
        }
        return createOtherPoints(beforeLine, height);
    }

    private List<Point> createFirstPoints(int height) {
        return IntStream.range(0, height)
                .mapToObj(currentHeight -> pointCreationStrategy.createNextPoint(Point.NOTHING))
                .collect(Collectors.toList());
    }

    private List<Point> createOtherPoints(Line beforeLine, int height) {
        return IntStream.range(0, height)
                .mapToObj(beforeLine::horizontalLine)
                .map(pointCreationStrategy::createNextPoint)
                .collect(Collectors.toList());
    }
}
