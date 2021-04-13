package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int MIDDLE_FIRST_INDEX = 1;

    private static List<Point> points;

    private Line(List<Point> points){
        this.points = points;
    }

    public static Line of(int countOfPerson, BooleanGenerator booleanGenerator) {
        validateLine(countOfPerson);
        createFirstPoint(booleanGenerator);
        createMiddlePoint(countOfPerson, booleanGenerator);
        createLastPoint();
        return new Line(points);
    }

    private static void validateLine(int countOfPerson) {
        if(countOfPerson < 2){
            throw new IllegalArgumentException(Members.MEMBERS_MIN_SIZE_TWO_EXCEPTION_MESSAGE);
        }
    }

    private static void createFirstPoint(BooleanGenerator booleanGenerator) {
        points.add(Point.first(booleanGenerator));
    }

    private static void createMiddlePoint(int countOfPerson, BooleanGenerator booleanGenerator) {
        for (int i = MIDDLE_FIRST_INDEX; i < countOfPerson - 1; i++) {
            if (points.get(i - 1).hasLine()) {
                points.add(new Point(false));
                continue;
            }
            points.add(new Point(booleanGenerator.nextBoolean()));
        }
    }

    private static void createLastPoint() {
        points.add(Point.last());
    }

    public List<Point> getLine() {
        return points;
    }

    public int getLineSize() {
        return points.size();
    }
}
