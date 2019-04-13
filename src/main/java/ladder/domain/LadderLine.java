package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private static final String EMPTY_LINE = "     ";
    private final List<Point> points;
    private BooleanGenerator booleanGenerator;
    private int countOfPerson;

    public LadderLine(int countOfPerson, BooleanGenerator booleanGenerator) {
        this.points = new ArrayList<>();
        this.booleanGenerator = booleanGenerator;
        this.countOfPerson = countOfPerson;
        init();
    }

    public int lineCount() {
        return points.size();
    }

    private void init() {
        Point point = initFirst();
        point = initBody(point);
        initLast(point);
    }

    private Point initBody(Point point) {
        for(int i = 1; i < countOfPerson - 1; i++) {
            point = point.next(booleanGenerator);
            points.add(point);
        }
        return point;
    }

    private Point initFirst() {
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
        for(int i = 0; i < points.size(); i++) {
            stringBuffer.append(points.get(i).toString());
        }
        return stringBuffer.toString();
    }
}
