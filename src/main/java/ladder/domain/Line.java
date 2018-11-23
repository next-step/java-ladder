package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


public class Line {

    private static final int START_POINT = 0;
    private static final int DEFAULT_ONE = 1;

    private List<Point> points;

    private Line (int countOfPerson) {
        points = new ArrayList<>();
        int countOfLine = countOfPerson - DEFAULT_ONE;
        IntStream.range(START_POINT, countOfLine)
                .forEach(count -> points.add(makePoints(count)));
    }

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line from (int countOfPerson) {
        return new Line(countOfPerson);
    }

    public static Line from (List<Point> points) {
        return new Line(points);
    }

    public List<Point> getPoints() {
        return points;
    }

    public int pointCount() {
        return points.size();
    }

    public boolean isExistPoint(int position) {
        return points.get(position).isPoint();
    }

    private Point makePoints(int count) {
        boolean result = new Random().nextBoolean();
        if (count == START_POINT) {
            return new Point(result);
        }
        if (isValidateLine(points.get(count - DEFAULT_ONE).isPoint(), result))
            return new Point(false);

        return new Point(result);
    }

    public boolean isValidateLine(boolean preResult, boolean result) {
        return preResult && result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|");
        points.forEach(point -> stringBuilder.append(point.toString()));
        return stringBuilder.toString();
    }
}
