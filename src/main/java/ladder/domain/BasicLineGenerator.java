package ladder.domain;

import java.util.List;

public class BasicLineGenerator implements LineGenerator {
    private final PointGenerator pointGenerator;

    public BasicLineGenerator(PointGenerator pointGenerator) {
        this.pointGenerator = pointGenerator;
    }

    @Override
    public Line generate(int width) {
        List<Point> points = pointGenerator.generate(width);
        return new Line(points);
    }
}
