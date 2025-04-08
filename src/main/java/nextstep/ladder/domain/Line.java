package nextstep.ladder.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        validate(points);
        this.points = new ArrayList<>(points);
    }

    private void validate(List<Boolean> points) {
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i - 1) && points.get(i)) {
                throw new RuntimeException("연속으로 가로선이 존재할 수는 없습니다.");
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
        if (start < this.points.size() && this.points.get(start)) {
            return start + 1;
        }
        if (start > 0 && this.points.get(start - 1)) {
            return start - 1;
        }
        return start;
    }

    public int getWidth() {
        return this.points.size();
    }

    public List<Boolean> getPoints() {
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
