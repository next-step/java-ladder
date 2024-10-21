package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {
    private List<Point> points = new ArrayList<>();
    private LineGenerator lineGenerator;

    public Line(int countOfPlayers, LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
        IntStream.range(0, countOfPlayers - 1)
                .forEach(it -> this.points.add(makeLine(it)));
    }

    public Line(List<Point> points, LineGenerator lineGenerator) {
        this.points = points;
        this.lineGenerator = lineGenerator;
    }

    private Point makeLine(int i) {
        Point point = new Point();
        point.next(hasPreviousLine(i), lineGenerator.generate());
        return point;
    }

    private boolean hasPreviousLine(int i) {
        return !this.points.isEmpty() && points.get(i - 1).getValue();
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
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
        return Objects.deepEquals(points, line.points);
    }

    // hashCode 메서드 오버라이드
    @Override
    public int hashCode() {
        return Objects.hash(points); // points를 기반으로 해시코드 생성
    }
}
