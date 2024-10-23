package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {
    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
        validatePoints(points.size());
    }

    public static Line of(int countOfPlayers, LineGenerator lineGenerator) {
        List<Point> points = new ArrayList<>();
        IntStream.range(0, countOfPlayers - 1)
                .forEach(idx -> {
                    Point point = new Point();
                    point.next(hasPreviousLine(idx, points), lineGenerator.generate());
                    points.add(point);
                });
        return new Line(points);
    }

    private static boolean hasPreviousLine(int idx, List<Point> points) {
        return !points.isEmpty() && points.get(idx - 1).getValue();
    }

    private void validatePoints(int count) {
        IntStream.range(0, count).forEach(it -> {
            if (it > 0 && this.points.get(it - 1).getValue() && this.points.get(it).getValue()) {
                throw new IllegalArgumentException("executive true error");
            }
        });
    }

    public List<Point> getPoints() {
        return points;
    }

    public int move(int startIdx) {
        if (hasNext(startIdx)) {
            return MoveType.NEXT.getNextMove(startIdx);
        }
        if (hasPrevious(startIdx)) {
            return MoveType.BACK.getNextMove(startIdx);
        }
        return MoveType.STAY.getNextMove(startIdx);
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
