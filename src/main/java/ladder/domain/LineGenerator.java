package ladder.domain;

public class LineGenerator {

    private LineGenerator() {
    }

    public static Line generate(int pointCount) {
        return new Line(PointGenerator.makePoints(pointCount));
    }
}
