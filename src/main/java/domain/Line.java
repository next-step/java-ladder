package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points = new ArrayList<>();

    public Line(int countOfPerson) {
        this.createLines(countOfPerson);
    }

    private void createLines(int countOfPerson) {
        this.points.add(Point.createPoint(false, Point.isNextPoint(false)));
        boolean isLeft = this.isLeft(this.points.get(0));

        for (int i = 1; i < countOfPerson - 1; i++) {
            Point point = Point.createPoint(isLeft, Point.isNextPoint(isLeft));
            this.points.add(point);
            isLeft = this.isLeft(point);
        }
        this.points.add(Point.createPoint(isLeft, false));
    }

    public boolean isLeft(Point point) {
        return point.isRightMovable();
    }

    public int movePoint(int startPoint) {
        return startPoint + this.points.get(startPoint).movePoint();
    }

    public String printLine() {
        String result = "";
        for (Point point : this.points) {
            result += point.lineType(point);
        }
        return result;
    }
}
