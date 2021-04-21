package ladder.domain;

import java.util.List;

public class LineGeneratorImpl implements LineGeneratorInterface {
    private final PointGeneratorInterface pointGeneratorInterface;

    public LineGeneratorImpl(PointGeneratorInterface pointGeneratorInterface) {
        this.pointGeneratorInterface = pointGeneratorInterface;
    }

    @Override
    public Line generate(int with) {
        List<Point> points = pointGeneratorInterface.generate(with);
        return new Line(points);
    }
}
