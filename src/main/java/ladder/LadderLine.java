package ladder;

import java.util.List;
import java.util.stream.Collectors;

public class LadderLine {
    private final List<Point> points;

    public static LadderLine from(PointGenerator pointGenerator) {
        return new LadderLine(pointGenerator.generate());
    }

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public List<Integer> move() {
        return points.stream()
                .map(Point::move)
                .collect(Collectors.toList());
    }

    public int move(int pointIndex) {
        return points.get(pointIndex).move();
    }
}
