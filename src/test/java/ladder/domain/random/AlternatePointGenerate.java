package ladder.domain.random;

import ladder.domain.ladder.Point;
import ladder.random.PointGenerator;

public class AlternatePointGenerate implements PointGenerator {
    private final Point[] points = Point.values();
    private int index = 0;

    @Override
    public Point generate() {
        return points[(index++) % 2];
    }
}
