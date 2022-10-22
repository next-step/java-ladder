package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ladder.model.Direction.first;

public class LadderLine {

    private List<Point> pointList;

    private static final Random RANDOM;

    static {
        RANDOM = new Random();
    }

    public LadderLine(List<Point> pointList) {
        this.pointList = pointList;
    }

    public static LadderLine create(int width) {
        List<Point> points = new ArrayList<>();

        Point point = createFirst(points);
        point = createBody(width, points, point);
        createLast(points, point);

        return new LadderLine(points);
    }

    private static Point createFirst(List<Point> points) {
        Point point = new Point(0, first(getRandomBoolean()));
        points.add(point);
        return point;
    }

    private static Point createBody(int width, List<Point> points, Point point) {
        for (int i = 1; i < width - 1; i++) {
            point = point.next(getRandomBoolean());
            points.add(point);
        }

        return point;
    }

    private static void createLast(List<Point> points, Point point) {
        points.add(point.last());
    }

    private static boolean getRandomBoolean() {
        return RANDOM.nextBoolean();
    }

    public List<Point> getPointList() {
        return pointList;
    }
}
