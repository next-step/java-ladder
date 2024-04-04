package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson) {
        initializeLine(countOfPerson);
    }

    public Line(List<Boolean> points) {
        for (Boolean point : points) {
            addLineValue(new Point(point));
        }
    }

    private void initializeLine(int countOfPerson) {
        Point previousPoint = new Point(false);
        for (int count = 0; count < countOfPerson - 1; count++) {
            previousPoint = addLineValue(previousPoint);
        }
    }

    private Point addLineValue(Point previousPoint) {
        Point newStatus = previousPoint.decideNextPoint();
        points.add(newStatus);
        return newStatus;
    }

    public List<Point> getPoints() {
        return points;
    }

}
