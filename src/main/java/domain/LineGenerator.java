package domain;

import java.util.ArrayList;
import java.util.List;

public interface LineGenerator {
    List<Point> createPoints(int lineSize);

    default Line generate(int lineSize) {
        List<Point> points = new ArrayList<>(lineSize);

        while (points.stream().filter(p -> p.hasDirectionType(DirectionType.NONE)).count() == points.size()) {
            points = this.createPoints(lineSize);
        }

        return new Line(points);
    }
}
