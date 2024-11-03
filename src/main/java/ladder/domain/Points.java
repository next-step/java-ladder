package ladder.domain;

import ladder.generator.Strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Points {
    private static final String CONSECUTIVE_ERROR_MESSAGE = "연속으로 중복 될 수 없는 값이 존재합니다.";

    private final List<Point> points = new ArrayList<>();

    public Points(Boolean... points) {
        this.points.addAll(parse(points));
    }

    public List<Point> parse(Boolean... points) {
        isValid(points);

        return Arrays.stream(points)
                .map(Point::new)
                .collect(Collectors.toList());
    }

    public void isValid(Boolean... points) {
        // Stream을 사용하여 연속된 true 값 검증
        IntStream.range(1, points.length)
                .filter(i -> points[i] && points[i - 1])
                .findFirst()
                .ifPresent(i -> {
                    throw new IllegalArgumentException(CONSECUTIVE_ERROR_MESSAGE);
                });
    }

    public void addHorizontal(int num, Strategy strategy) {
        if (isValid(num) && strategy.randomLadder()) {
            this.points.add(new Point(true));
            return;
        }
        this.points.add(new Point(false));
    }

    public boolean isValid(int number) {
        return !points.isEmpty() && !points.get(number - 1).isPoint();
    }

    public boolean canMoveLeft(int position) {
        return position > 0 && hasLine(position);
    }

    public boolean canMoveRight(int position) {
        return position < points.size() - 1 && hasLine(position + 1);
    }

    private boolean hasLine(int position) {
        return points.get(position).isPoint();
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Points points1 = (Points) o;
        return Objects.equals(points, points1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

}
