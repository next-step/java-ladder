package nextstep.ladder.model.v2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LadderLine implements Iterable<Point> {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int index) {
        return points.get(index).move();
    }

    public static LadderLine init(int sizeOfPerson, LadderPointGenerator generator) {
        List<Point> points = new ArrayList<>();

        initFirst(points, generator);
        initMiddle(sizeOfPerson, points, generator);
        initLast(points);

        return new LadderLine(points);
    }

    private static void initFirst(List<Point> points, LadderPointGenerator generator) {
        points.add(Point.first(generator.generatePoint()));
    }

    private static void initMiddle(int sizeOfPerson, List<Point> points, LadderPointGenerator generator) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            points.add(points.get(points.size() - 1).next(generator));
        }
    }

    private static void initLast(List<Point> points) {
        points.add(points.get(points.size() - 1).last());
    }

    @Override
    public Iterator<Point> iterator() {
        return points.iterator();
    }
}
