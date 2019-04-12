package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import static ladder.domain.BooleanGenerator.generatePoint;

public class LadderLine {
    private static final String EMPTY_LINE = "     ";
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int lineCount() {
        return points.size();
    }

    public static LadderLine init(int countOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(countOfPerson, points, point);
        initLast(points, point);

        return new LadderLine(points);
    }

    private static Point initBody(int countOfPerson, List<Point> points, Point point) {
        for(int i = 1; i < countOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(generatePoint());
        points.add(point);
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
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
