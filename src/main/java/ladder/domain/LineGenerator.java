package ladder.domain;

public class LineGenerator {

    public Line generate(int pointCount) {
        PointGenerator pointGenerator = PointGenerator.of(pointCount);
        Point firstPoint = pointGenerator.first();
        Point lastBodyPoint = pointGenerator.body(firstPoint);
        pointGenerator.last(lastBodyPoint);

        return new Line(pointGenerator.toPoints());
    }
}
