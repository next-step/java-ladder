package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public static List<Line> createLines(int countOfLine, int countOfPoint) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, countOfLine)
                .forEach(number -> lines.add(createLine(countOfPoint)));

        return lines;
    }

    private static Line createLine(int countOfPoint) {
        List<Point> points = new ArrayList<>(List.of(new Point()));
        IntStream.range(1, countOfPoint)
                .forEach(number -> {
                    Point currentPoint = points.get(points.size() - 1);
                    points.add(currentPoint.createNextPoint());
                });

        return new Line(points);
    }
}
