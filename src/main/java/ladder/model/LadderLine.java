package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ladder.model.Direction.first;

public class LadderLine {

    private List<Point> points;

    private static final Random RANDOM;

    static {
        RANDOM = new Random();
    }

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine create(int width) {
        List<Point> points = new ArrayList<>();

        points.add(createFirst());
        points.addAll(createBody(width, points.get(0)));
        points.add(createLast(points.get(points.size() - 1)));

        return new LadderLine(points);
    }

    private static Point createFirst() {
        return new Point(0, first(getRandomBoolean()));
    }

    private static List<Point> createBody(int width, Point point) {
        List<Point> points = new ArrayList<>();

        for (int i = 1; i < width - 1; i++) {
            point = point.next(getRandomBoolean());
            points.add(point);
        }

        return points;
    }

    private static Point createLast(Point point) {
        return point.last();
    }

    private static boolean getRandomBoolean() {
        return RANDOM.nextBoolean();
    }

    public List<Point> getPoints() {
        return points;
    }

    public int move(int position) {
        return points.get(position).move();
    }
}
