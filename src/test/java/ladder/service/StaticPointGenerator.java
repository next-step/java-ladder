package ladder.service;

import ladder.domain.Point;

import java.util.List;

public class StaticPointGenerator implements PointGenerator {
    private final List<Boolean> staticPoints;
    private int pointer = 0;

    public StaticPointGenerator(List<Boolean> staticPoints) {
        this.staticPoints = staticPoints;
    }

    @Override
    public Point generate(int index, List<Point> points) {
        return new Point(staticPoints.get(pointer++));
    }
}
