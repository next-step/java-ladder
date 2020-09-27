package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPersons) {
        if (countOfPersons < 1) {
            throw new IllegalStateException("사다리 타기의 최소 인원 수는 1명 입니다.");
        }
        if (countOfPersons == 1) {
            return;
        }
        points.add(Point.random());
    }

    public static Line random(int countOfPersons) {
        Line line = new Line(countOfPersons);

        for (int i = 1; i < countOfPersons - 1; i++) {
            line.addRandomPoint(i);
        }
        return line;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }

    public List<Point> getPoints() {
        return points;
    }

    private void addRandomPoint(int index) {
        Point beforePoint = points.get(index - 1);
        if (beforePoint.isExist()) {
            points.add(Point.ofNotExist());
            return;
        }
        points.add(Point.random());
    }
}
