package ladder.domain.point;

import static ladder.domain.Position.LINE_START_POSITION;

import ladder.domain.Position;
import ladder.domain.direction.DirectionStrategy;

public class PointGenerator {

    private final DirectionStrategy directionStrategy;

    public PointGenerator() {
        this.directionStrategy = DirectionStrategy.newInstance();
    }

    public PointGenerator(DirectionStrategy directionStrategy) {
        this.directionStrategy = directionStrategy;
    }

    public Point generateNextPoint(Point previous, Position position) {
        return new Point(position, directionStrategy.getNextDirection(previous.getDirection()));
    }

    public Point generateLineStartPoint() {
        return new Point(LINE_START_POSITION, directionStrategy.getDirectionToStart());
    }

    public Point generateLineEndPoint(Point previous, Position endPosition) {
        return new Point(endPosition, directionStrategy.getDirectionToEnd(previous.getDirection()));
    }
}
