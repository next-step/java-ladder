package domain;

import java.util.ArrayList;
import java.util.List;

import static utility.generatorPoint.makeDirection;
import static view.View.ONE;
import static view.View.ZERO;

public class Line {
    private List<Point> points = new ArrayList<>();
    private int result;

    public Line(int countOfPerson) {
        validateInput(countOfPerson);
        Point point = makeFirstPoint();
        point = makeIntermediatePoint(countOfPerson, point);
        makeEndPoint(point);
    }

    private void validateInput(int countOfPerson) {
        if (countOfPerson <= ONE) {
            throw new IllegalArgumentException("Input size ERR!");
        }
    }

    private Point makeFirstPoint() {
        Point point = new Point(ZERO, false, makeDirection());
        points.add(point);
        return point;
    }

    private Point makeIntermediatePoint(int countOfPerson, Point point) {
        Point newPoint;

        for (int i = 1; i < countOfPerson - 1; i++) {
            newPoint = point.next();
            points.add(newPoint);
            point = newPoint;
        }
        return point;
    }

    private void makeEndPoint(Point point) {
        points.add(point.last());
    }

    public List<Point> getPoints() {
        return points;
    }

    int goDownLadder(List<Line> lines, int index, int height) {
        if (height == Ladder.LADDER_HEIGHT + ONE) {
            result = index;
            return index;
        }
        Point start = getStartPoint(lines, height, index);

        boolean right = start.isRight();
        boolean left = start.isLeft();

        if (!right && !left) {
            goDownLadder(lines, index, height + ONE);
        }
        if (right) {
            goDownLadder(lines, index + ONE, height + ONE);
        }
        if (left) {
            goDownLadder(lines, index - ONE, height + ONE);
        }
        return result;
    }

    private Point getStartPoint(List<Line> lines, int height, int index) {
        return lines.get(height - ONE).getPoints().get(index);
    }
}
