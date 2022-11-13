package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final int ZERO = 0;
    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public int size() {
        return points.size();
    }

    public void checkPointAndChangePosition(Players players) {
        IntStream.range(ZERO, size())
                .filter(point -> points.get(point).isPoint())
                .forEach(i -> players.changePositions(i));
    }

    public static Line createLine(int countPerson) {
        List<Point> points = new ArrayList<>();

        IntStream.range(0, countPerson - 1)
                .forEach(i -> points.add(Point.addPoint(i, points)));

        return new Line(points);
    }
}
