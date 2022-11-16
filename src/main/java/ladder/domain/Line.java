package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static ladder.util.RandomLine.addPoint;

public class Line {
    private List<Boolean> points;

    public Line(int countOfPerson) {
        this(createLine(countOfPerson));
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    private static List<Boolean> createLine(int countPerson) {
        List<Boolean> points = new ArrayList<>();
        IntStream.range(0, countPerson)
                .forEach(i -> points.add(makePoint(i, points)));
        return points;
    }

    private static Boolean makePoint(int count, List<Boolean> points) {
        if (points.isEmpty() || points.get(count - 1)) {
            return false;
        }
        return addPoint(count, points);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
