package ladder.domain;

import ladder.generator.Strategy;

import java.util.*;
import java.util.stream.IntStream;

public class Line {
    private Points points;

    public Line(Points points) {
        this.points = points;
    }

    public Line(int countOfPerson, Strategy strategy) {
        points = new Points();
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        IntStream.range(0, countOfPerson)
                .forEach(num -> this.addHorizontal(num, strategy));

    }

    private void addHorizontal(int num, Strategy strategy) {
        this.points.addHorizontal(num, strategy);
    }

    public int move(int position) {
        if (this.points.canMoveLeft(position)) {
            return position - 1;
        }
        if (this.points.canMoveRight(position)) {
            return position + 1;
        }
        return position;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points.getPoints());
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
