package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final List<Point> points;
    private Difficulty difficulty;

    private LadderLine(int sizeOfPerson, Difficulty difficulty) {
        this.difficulty = difficulty;
        this.points = init(sizeOfPerson);
    }

    public static LadderLine create(int sizeOfPerson) {
        return new LadderLine(sizeOfPerson, Difficulty.MIDDLE);
    }

    public static LadderLine create(int sizeOfPerson, Difficulty difficulty) {
        return new LadderLine(sizeOfPerson, difficulty);
    }

    public int move(int index) {
        return points.get(index).move();
    }

    private List<Point> init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return points;
    }

    private Point initBody(int sizeOfPerson, List<Point> points, Point point) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(difficulty);
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private Point initFirst(List<Point> points) {
        Point point = Point.first(difficulty.generate());
        points.add(point);
        return point;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        points.forEach(point -> stringBuilder.append(point.toString()));
        return stringBuilder.toString();
    }
}
