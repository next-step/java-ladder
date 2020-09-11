package ladder.domain.line;

import ladder.domain.Point;

import java.util.Optional;

public class SteppingStoneOthersideLine implements LineStrategy {

    @Override
    public Point makePoint(Point prevPoint, int lastValue) {
        Optional<Point> opPoint = Optional.ofNullable(prevPoint);
        if (!opPoint.isPresent()) {
            return new Point(false, false);
        }

        boolean next = next(prevPoint.isNextPoint());

        if (lastValue == LAST_VALUE) {
            return new Point(prevPoint.isNextPoint(), false);
        }

        return new Point(prevPoint.isNextPoint(), next);
    }

    private boolean next(boolean prevPoint) {
        return !prevPoint;
    }
}
