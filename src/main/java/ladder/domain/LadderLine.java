package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.Boolean.*;


public class LadderLine {

    private static final int START_POINT = 0;
    private static final int DEFAULT_ONE = 1;

    private List<Point> points;

    private LadderLine(int countOfPerson) {
        points = new ArrayList<>();
        int countOfLine = countOfPerson - DEFAULT_ONE;
        IntStream.range(START_POINT, countOfLine)
                .forEach(count -> points.add(makePoints(count)));
    }

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine from (int countOfPerson) {
        return new LadderLine(countOfPerson);
    }

    public static LadderLine from (List<Point> points) {
        return new LadderLine(points);
    }

    public int pointCount() {
        return points.size();
    }

    public boolean isExistPoint(int position) {
        return points.get(position).isPoint();
    }

    private Point makePoints(int count) {
        boolean random = new Random().nextBoolean();
        if (count == START_POINT) {
            return new Point(random);
        }

        if (isValidateLine(points.get(count - DEFAULT_ONE).isPoint(), random)) {
            return new Point(FALSE);
        }

        return new Point(random);
    }

    public boolean isValidateLine(boolean first, boolean second) {
        return first && second;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|");
        points.forEach(point -> stringBuilder.append(point.toString()));
        return stringBuilder.toString();
    }
}
