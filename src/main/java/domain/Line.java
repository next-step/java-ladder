package domain;

import java.util.ArrayList;
import java.util.List;

import static utility.generatorPoint.makeDirection;
import static view.View.ONE;

public class Line {
    private List<Point> points = new ArrayList<>();

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
        Point point = new Point(0, false, makeDirection());
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

    public void goDownLadder(List<Line> lines, int index, int height) {
        if (height == Ladder.LADDER_HEIGHT + 1) {
            System.out.print("종료 ");
            System.out.println(index);
//            return index;
        }
        Point start = lines.get(height - 1).getPoints().get(index);

        boolean right = start.isRight();
        boolean left = start.isLeft();

        if (!right && !left) {
            goDownLadder(lines, index, height + 1);
        }

        if (right) {
            goDownLadder(lines, index + 1, height + 1);
        }
        if (left) {
            goDownLadder(lines, index - 1, height + 1);
        }
//        return index;
    }
}
