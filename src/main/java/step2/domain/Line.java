package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Line {
    private static final int INDEX_ONE = 1;
    private static final int ONE = 1;

    private List<Point> points;

    private Line(int countOfperson) {
        this.points = lineCreate(countOfperson);
    }

    public static List<Point> lineCreate(int countOfperson) {
        List<Point> points = new ArrayList<>();
        Point ladderLine = firstLine(points);
        ladderLine = makeMidLine(countOfperson, points, ladderLine);
        ladderLine = makeLastLine(ladderLine);
        points.add(ladderLine);
        return points;
    }

    private static Point firstLine(List<Point> points) {
        Point ladderLine = Point.first();
        points.add(ladderLine);
        return ladderLine;
    }

    private static Point makeMidLine(int countOfperson, List<Point> points, Point ladderLine) {
        for (int i = INDEX_ONE; i < countOfperson - ONE; i++){
            ladderLine = Point.drawVertical(i, ladderLine);
            points.add(ladderLine);
        }
        return ladderLine;
    }

    private static Point makeLastLine(Point ladderLine) {
        return Point.last(ladderLine);
    }

    public static Line of(int countOfPerson) {
        return new Line(countOfPerson);
    }

    public Stream<Point> Stream() {
        return points.stream();
    }
}
