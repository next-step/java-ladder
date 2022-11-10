package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points;

    public Line(int height) {
        points = IntStream.range(0, height)
                .mapToObj(i -> Point.NONE)
                .collect(Collectors.toList());
    }

    public List<Integer> emptyPoints() {
        return IntStream.range(0, points.size())
                .mapToObj(index -> Map.entry(index, points.get(index)))
                .filter(entry -> entry.getValue() == Point.NONE)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public void setPoint(int index, Point point) {
        points.set(index, point);
    }

    public boolean hasPoint(int index) {
        return points.get(index) != Point.NONE;
    }

    public Point getPoint(int index) {
        return points.get(index);
    }
}
