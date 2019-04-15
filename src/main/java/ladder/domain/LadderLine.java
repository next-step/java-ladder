package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private static final String EMPTY_LINE = "     ";
    private final List<Point> points;
    private int countOfPerson;

    public LadderLine(int countOfPerson, BooleanGenerator booleanGenerator) {
        this.points = new ArrayList<>();
        this.countOfPerson = countOfPerson;
        init(booleanGenerator);
    }

    public int lineCount() {
        return points.size();
    }

    private void init(BooleanGenerator booleanGenerator) {
        Point point = initFirst(booleanGenerator);
        point = initBody(point, booleanGenerator);
        initLast(point);
    }

    private Point initBody(Point point, BooleanGenerator booleanGenerator) {
        for(int i = 1; i < countOfPerson - 1; i++) {
            point = point.next(booleanGenerator);
            points.add(point);
        }
        return point;
    }

    private Point initFirst(BooleanGenerator booleanGenerator) {
        Point point = Point.first(booleanGenerator.generatePoint());
        points.add(point);
        return point;
    }

    private void initLast(Point point) {
        point = point.last();
        points.add(point);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(EMPTY_LINE);
        for (Point point : points) {
            stringBuffer.append(point.toString());
        }
        return stringBuffer.toString();
    }
}
