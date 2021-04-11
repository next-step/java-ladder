package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points = new ArrayList<>();

    public Line(int countOfPerson) {
        points.add(firstPoint());
        points.add(lastPoint());
    }


    private Point firstPoint() {
        return new Point(true);
    }

    private Point lastPoint() {
        return new Point(false);
    }
}
