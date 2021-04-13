package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int MIDDLE_FIRST_INDEX = 1;

    private List<Point> points;

    private Line(List<Point> points){
        this.points = points;
    }

    public static Line of(int countOfPerson, BooleanGenerator booleanGenerator) {
        validateLine(countOfPerson);
        return createPoints(countOfPerson, booleanGenerator);
    }

    private static Line createPoints(int countOfPerson, BooleanGenerator booleanGenerator) {
        List<Point> newPoint = new ArrayList<>();
        createFirstPoint(booleanGenerator, newPoint);
        createMiddlePoint(countOfPerson, booleanGenerator, newPoint);
        createLastPoint(newPoint);
        return new Line(newPoint);
    }

    private static void validateLine(int countOfPerson) {
        if(countOfPerson < 2){
            throw new IllegalArgumentException(Members.MEMBERS_MIN_SIZE_TWO_EXCEPTION_MESSAGE);
        }
    }

    private static void createFirstPoint(BooleanGenerator booleanGenerator, List<Point> points) {
        points.add(Point.first(booleanGenerator));
    }

    private static void createMiddlePoint(int countOfPerson, BooleanGenerator booleanGenerator, List<Point> points) {
        for (int i = MIDDLE_FIRST_INDEX; i < countOfPerson - 1; i++) {
            if (points.get(i - 1).hasLine()) {
                points.add(new Point(false));
                continue;
            }
            points.add(new Point(booleanGenerator.nextBoolean()));
        }
    }

    private static void createLastPoint(List<Point> points) {
        points.add(Point.last());
    }

    public List<Point> getLine() {
        return points;
    }

    public int getLineSize() {
        return points.size();
    }
}
