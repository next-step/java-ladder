package ladder;

import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        verifyCountOfPerson(points);
        this.points = points;
    }

    private void verifyCountOfPerson(List<Point> points) {
        if (points.size() < 2) {
            throw new IllegalArgumentException("사다리게임은 두 명이상부터만 가능합니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        points.forEach(sb::append);
        return sb.toString();
    }

    public int getNumberOfPoints() {
        return points.size();
    }
}