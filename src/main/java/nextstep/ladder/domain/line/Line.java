package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.domain.RandomGenerator;

public class Line {

    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson) {
        initializeLine(countOfPerson);
    }

    private void initializeLine(int countOfPerson) {
        Point point = new Point(false);
        for (int count = 0; count < countOfPerson - 1; count++) {
            point = addLineValue(point);
        }
    }

    private Point addLineValue(
        Point previousPoint) {
        Point newStatus =
            previousPoint.isLadderConstructionStatusFalse()
                ? new Point(RandomGenerator.createRandomBoolean())
                : new Point(false);
        points.add(newStatus);
        return newStatus;
    }

    public List<Point> getPoints() {
        return points;
    }

    public int size() {
        return points.size();
    }
}
