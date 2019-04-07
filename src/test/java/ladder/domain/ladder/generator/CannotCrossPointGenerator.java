package ladder.domain.ladder.generator;

import ladder.domain.ladder.Point;

public class CannotCrossPointGenerator implements PointGenerator {
    @Override
    public Point generate(Point previous) {
        return Point.CANNOT_CROSS_POINT;
    }

    @Override
    public Point generateLeftmost() {
        return Point.CANNOT_CROSS_POINT;
    }

    @Override
    public Point generateRightmost(Point previous) {
        return Point.CANNOT_CROSS_POINT;
    }
}
