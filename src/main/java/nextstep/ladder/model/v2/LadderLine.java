package nextstep.ladder.model.v2;

import java.util.ArrayList;
import java.util.List;

import static nextstep.ladder.model.v2.LadderPointGenerator.generatePoint;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int index) {
        return points.get(index).move();
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();

        initFirst(points);
        initMiddle(sizeOfPerson, points);
        initLast(points);

        return new LadderLine(points);
    }

    private static void initFirst(List<Point> points) {
        points.add(Point.first(generatePoint()));
    }

    private static void initMiddle(int sizeOfPerson, List<Point> points) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            points.add(points.get(points.size() - 1).next());
        }
    }

    private static void initLast(List<Point> points) {
        points.add(points.get(points.size() - 1).last());
    }
}
