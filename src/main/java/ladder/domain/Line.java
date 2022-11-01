package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points;

    public Line(int height) {
        points = IntStream.range(0, height)
                .mapToObj(i -> Point.NONE)
                .collect(Collectors.toList());
    }

    public void setPoint(int index, Point point) {
        points.set(index, point);
    }

    public boolean hasPoint(int index) {
        return points.get(index) != Point.NONE;
    }

    public List<Integer> emptyPoints() {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            if (point == Point.NONE) {
                results.add(i);
            }
        }
        return results;
    }
}
