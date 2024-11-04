package ladder.domain;

import ladder.generator.Strategy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private static final String CONSECUTIVE_ERROR_MESSAGE = "연속으로 중복 될 수 없는 값이 존재합니다.";

    private List<Point> points = new ArrayList<>();

    public Line(Boolean... points) {
        this.points.addAll(parse(points));
    }

    public Line(List<Point> points) {
        this.points = points;
    }

    public Line(int countOfPerson, Strategy strategy) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        IntStream.range(0, countOfPerson)
                .forEach(num -> this.addHorizontal(num, strategy));

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

    public int move(int position) {
        if (this.canMoveLeft(position)) {
            return position - 1;
        }
        if (this.canMoveRight(position)) {
            return position + 1;
        }
        return position;
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
        return Collections.unmodifiableList(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }

}
