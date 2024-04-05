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

    public boolean canMoveRight(int userIndex) {
        if (userIndex + 1 < points.size() + 1 && points.get(userIndex).isPointTrue()) {
            return true;
        }
        return false;
    }

    public boolean canMoveLeft(int userIndex) {
        if (userIndex - 1 >= 0 && points.get(userIndex - 1).isPointTrue()) {
            return true;
        }
        return false;
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
