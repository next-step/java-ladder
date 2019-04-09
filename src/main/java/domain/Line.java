package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points = new ArrayList<>();

    public Line(int countOfPerson) {
        this.createLines(countOfPerson);
    }

    private void createLines(int countOfPerson) {
        this.points.add(Point.first());
        boolean isLeft = this.isRight(this.points.get(0));

        for (int i = 1; i < countOfPerson - 1; i++) {
            Point point = Point.next(isLeft);
            this.points.add(point);
            isLeft = this.isRight(point);
        }
        this.points.add(Point.last(isLeft));
    }

    boolean isRight(Point point) {
        return point.isRight();
    }

    public Integer location(Line line, int startPoint) {
        List<Point> points = line.points;
        if (points.get(startPoint).isRight()) {
            return startPoint + 1;
        } else if (points.get(startPoint).isLeft()) {
            return startPoint - 1;
        }
        return startPoint;
    }

    public String printLine() {
        String result = "";
        for (Point point : this.points) {
            result += point.lineType(point);
        }
        return result;
    }
}
