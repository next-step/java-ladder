package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> line = new ArrayList<>();

    public Line(int countOfPersons) {
        if (countOfPersons < 1) {
            throw new IllegalStateException("사다리 타기의 최소 인원 수는 1명 입니다.");
        }
        if (countOfPersons == 1) {
            return;
        }
        line.add(Point.random());
    }

    public static Line of(int countOfPersons) {
        Line line = new Line(countOfPersons);

        for (int i = 1; i < countOfPersons - 1; i++) {
            line.addPoint(i);
        }
        return line;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + line +
                '}';
    }

    public int getCount() {
        return line.size();
    }

    public List<Point> getLine() {
        return line;
    }

    private void addPoint(int index) {
        Point beforePoint = line.get(index - 1);
        if (beforePoint.isExist()) {
            line.add(Point.ofNotExist());
            return;
        }
        line.add(Point.random());
    }
}
