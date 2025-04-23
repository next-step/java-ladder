package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<LinePoint> linePoints;

    public Line(List<LinePoint> linePoints) {
        this.linePoints = List.copyOf(linePoints);
    }

    public static Line generate(int numLines, LineDrawStrategy strategy) {
        List<LinePoint> result = new ArrayList<>();
        boolean current = strategy.draw(false);
        Point point = Point.first(current);
        result.add(new LinePoint(0, point));

        for (int i = 1; i < numLines - 1; i++) {
            current = strategy.draw(current);
            point = point.next(current);
            result.add(new LinePoint(i, point));
        }
        result.add(new LinePoint(numLines - 1, point.last()));

        return new Line(result);
    }

    public int move(int position) {
        return linePoints.get(position).move();
    }

    public List<LinePoint> getLinePoints() {
        return linePoints;
    }
}
