package ladder.support;

import ladder.domain.Line;
import ladder.domain.Point;
import ladder.domain.generator.LineGenerator;

import java.util.List;

public class FixedLineGenerator implements LineGenerator {
    private List<Point> points;

    public FixedLineGenerator(List<Point> points) {
        this.points = points;
    }

    @Override
    public Line generate(int countOfPerson) {
        return new Line(points.subList(0, countOfPerson));
    }
}
