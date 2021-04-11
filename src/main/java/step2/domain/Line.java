package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points = new ArrayList<>();

    public Line(int countOfPerson, BooleanGenerator booleanGenerator) {
        points.add(Point.first(booleanGenerator));
        createMiddlePoint(countOfPerson, booleanGenerator);
        points.add(Point.last());
    }

    private void createMiddlePoint(int countOfPerson, BooleanGenerator booleanGenerator) {
        for (int i = 1; i < countOfPerson - 1; i++) {
            if (points.get(i - 1).hasLine()) {
                points.add(new Point(false));
                continue;
            }
            points.add(new Point(booleanGenerator.nextBoolean()));
        }
    }

    public List<Point> getLine() {
        return this.points;
    }

    public int getLineSize() {
        return this.points.size();
    }
}
