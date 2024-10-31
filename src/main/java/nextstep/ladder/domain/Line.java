package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String VALIDATE_COUNT_PERSON = "참여자는 2명 이상이어야 합니다.";
    private static final String LADDER_START = "|";
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line create(int countOfPerson) {
        validateCountOfPerson(countOfPerson);
        List<Point> points = initPoints(countOfPerson);
        return new Line(points);
    }

    private static void validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < 2) {
            throw new IllegalArgumentException(VALIDATE_COUNT_PERSON);
        }
    }

    private static List<Point> initPoints(int countOfPerson) {
        List<Point> points = new ArrayList<>();
        points.add(new Point());
        for (int i = 1; i < countOfPerson - 1; i++) {
            points.add(new Point(points.get(i - 1)));
        }
        return points;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        StringBuilder lineOutput = new StringBuilder(LADDER_START);
        for (Point point : points) {
            lineOutput.append(point.toString());
        }
        return lineOutput.toString();
    }
}
