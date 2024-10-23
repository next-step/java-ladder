package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {
    private List<Point> points = new ArrayList<>();

    public Line(int countOfPlayers, LineGenerator lineGenerator) {
        IntStream.range(0, countOfPlayers - 1)
                .forEach(it -> this.points.add(makeLine(it, lineGenerator)));
        validatePoints(countOfPlayers - 1);
    }


    public Line(List<Point> points) {
        this.points = points;
        validatePoints(points.size());
    }


    private void validatePoints(int count) {
        IntStream.range(0, count).forEach(it -> {
            if (it > 0 && this.points.get(it - 1).getValue() && this.points.get(it).getValue()) {
                throw new IllegalArgumentException("executive true error");
            }
        });
    }

    private Point makeLine(int i, LineGenerator lineGenerator) {
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

    public int move(int startIdx) {
        if (hasNext(startIdx)) {
            return startIdx + 1;
        }
        if (hasPrevious(startIdx)) {
            return startIdx - 1;
        }
        return startIdx;
    }

    private boolean hasPrevious(int startIdx) {
        return startIdx > 0 && this.points.get(startIdx - 1).getValue();
    }

    private boolean hasNext(int startIdx) {
        return startIdx < this.points.size() && this.points.get(startIdx).getValue();
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
