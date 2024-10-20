package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private LineGenerator lineGenerator;

    public Line(int countOfPlayers, LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
        IntStream.range(0, countOfPlayers - 1)
                .forEach(it -> this.points.add(makeLine(it)));
    }

    public Line(List<Boolean> points, LineGenerator lineGenerator) {
        this.points = points;
        this.lineGenerator = lineGenerator;
    }

    private boolean makeLine(int i) {
        if (i == 0) {
            return this.lineGenerator.generate();
        }
        return !points.get(i - 1) && this.lineGenerator.generate();
    }

    public List<Boolean> getPoints() {
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
