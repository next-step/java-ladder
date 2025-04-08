package nextstep.ladder.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points;

    public Line(List<Boolean> points) {
        List<Point> pointList = points.stream()
                .map(Point::new)
                .collect(Collectors.toList());
        validate(pointList);
        this.points = pointList;
    }

    private void validate(List<Point> points) {
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i - 1).isPresent() && points.get(i).isPresent()) {
                throw new RuntimeException("연속으로 가로점이 존재할 수는 없습니다.");
            }
        }
    }

    public static Line createRandomLine(int width, Random random) {
        List<Boolean> points = IntStream.range(0, width - 1)
                .mapToObj(i -> false)
                .collect(Collectors.toList());

        for (int i = 0; i < width - 1; i++) {
            if (random.nextBoolean()) {
                points.set(i, true);
                i++;
            }
        }

        return new Line(points);
    }

    public int move(int start) {
        if (start < points.size() && points.get(start).isPresent()) {
            return start + 1;
        }
        if (start > 0 && points.get(start - 1).isPresent()) {
            return start - 1;
        }
        return start;
    }

    public int getWidth() {
        return this.points.size();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
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
        return Objects.hashCode(points);
    }
}
