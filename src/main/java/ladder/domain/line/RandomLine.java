package ladder.domain.line;

import ladder.domain.Point;

import java.util.Optional;
import java.util.Random;

public class RandomLine implements LineStrategy {

    private Random random = new Random();


    @Override
    public Point makePoint(Point prevPoint, int lastValue) {
        Optional<Point> opPoint = Optional.ofNullable(prevPoint);
        if (!opPoint.isPresent()) {
            return firstPoint();
        }

        if (lastValue == LAST_VALUE) {
            return lastPoint(prevPoint);
        }

        boolean nextPoint = opPoint.filter(Point::isNextPoint)
                .map(point -> false)
                .orElse(random.nextBoolean());

        return new Point(prevPoint.isNextPoint(), nextPoint);
    }

    public Point firstPoint() {
        return new Point(false, random.nextBoolean());
    }

    public Point lastPoint(Point prevPoint) {
        return new Point(prevPoint.isNextPoint(), false);
    }
}
