package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ladder.domain.ladder.RandomGenerator.isMovable;

public class Line {

    private static final int PERSON_START_END_COUNT = 2;

    private List<Point> points = new ArrayList<>();

    private Line (LineCount lineCount) {
        makeLine(lineCount);
    }

    public static Line createLine(LineCount lineCount) {
        return new Line(lineCount);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    private void makeLine(LineCount lineCount) {
        int countOfPerson = lineCount.getLineCount();

        Point point = Point.createFirstPoint(isMovable());
        points.add(point);

        int i = 0;

        while (getMiddlePerson(countOfPerson) > i) {
            point = point.next(isMovable());
            points.add(point);
            i += 1;
        }

        points.add(point.last());
    }

    private int getMiddlePerson(int countOfPerson) {
        return countOfPerson - PERSON_START_END_COUNT;
    }
}
