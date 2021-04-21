package ladder.domain;

import java.util.List;

public class BasicLineGenerator implements LineGenerator {
    private final PointGenerator pointGenerator;

    public BasicLineGenerator(PointGenerator pointGenerator) {
        this.pointGenerator = pointGenerator;
    }

    @Override
    public Line generate(int with) {
        List<Point> points = pointGenerator.generate(with);
        return new Line(points);
    }
}
