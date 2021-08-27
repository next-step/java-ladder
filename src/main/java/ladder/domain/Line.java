package ladder.domain;

import ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {
    private static final String LINE_TRUE = "-----";
    private static final String LINE_FALSE = "     ";
    private static final String LINE_DELIMITER = "|";

    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line valueOf(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        points.add(false);
        for (int i = 1; i < countOfPerson; i++) {
            points.add(PointStrategy.generate(points.get(i - 1)));
        }
        return new Line(points);
    }

    public String generateLineString() {
        return points.stream().map(flag -> flag ? LINE_TRUE : LINE_FALSE)
                     .collect(Collectors.joining(LINE_DELIMITER)) + "|";
    }

    public boolean point(int index) {
        return points.get(index);
    }

    public int size() {
        return points.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}