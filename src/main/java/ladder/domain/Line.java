package ladder.domain;

import ladder.generator.Strategy;

import java.util.*;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(Boolean... booleans) {
        this.points.addAll(Arrays.asList(booleans));
    }

    public Line(int countOfPerson, Strategy strategy) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        IntStream.range(0, countOfPerson)
                .forEach(num -> addHorizontal(num, strategy));

    }

    private void addHorizontal(int num, Strategy strategy) {
        if (isValidate(num) && strategy.randomLadder()) {
            this.points.add(true);
            return;
        }
        this.points.add(false);
    }

    public boolean isValidate(int num) {
        return !points.isEmpty() && !points.get(num - 1);
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
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
