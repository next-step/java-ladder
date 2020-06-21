package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final int LEFT = -1;
    private static final int RIGHT = 1;
    private static final int SAME = 0;

    private final List<Point> line;

    private Line(List<Point> line) {
        this.line = line;
    }

    public static Line valueOf(int countOfPerson, PointGenerator pointGenerator) {
        List<Point> line = new ArrayList<>();
        Point point = Point.stop();
        while (countOfPerson > 0) {
            point = addLine(line, pointGenerator, point);
            countOfPerson--;
        }
        return new Line(line);
    }

    private static Point addLine(List<Point> points, PointGenerator pointGenerator, Point point) {
        points.add(point);
        point = point.checkOverlap(pointGenerator.generate());
        return point;
    }

    public List<Point> getLine() {
        return Collections.unmodifiableList(line);
    }

    public int runLine(int finalPoint) {
        if (goLeft(finalPoint)) {
            return LEFT;
        }
        if (isNotLastLine(finalPoint) && goRight(finalPoint)) {
            return RIGHT;
        }
        return SAME;
    }

    private boolean isNotLastLine(int finalPoint) {
        return finalPoint < line.size() - 1;
    }

    private boolean goLeft(int finalPoint) {
        return line.get(finalPoint).isPoint();
    }

    private boolean goRight(int finalPoint) {
        return line.get(finalPoint + 1).isPoint();
    }
}
