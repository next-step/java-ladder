package ladder.model;

import java.util.ArrayList;
import java.util.List;

import static ladder.model.PointTdd.generatePoint;

public class LadderLineTdd {
    private final List<PointTdd> points;

    public LadderLineTdd(final List<PointTdd> points) {
        this.points = points;
    }

    public int move(final int position) {
        return points.get(position).move();
    }

    public static LadderLineTdd init(final int sizeOfPerson) {
        List<PointTdd> points = new ArrayList<>();
        PointTdd point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLineTdd(points);
    }

    private static PointTdd initBody(final int sizeOfPerson, final List<PointTdd> points, PointTdd point) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initLast(final List<PointTdd> points, PointTdd point) {
        point = point.last();
        points.add(point);
    }

    private static PointTdd initFirst(final List<PointTdd> points) {
        PointTdd point = PointTdd.first(generatePoint());
        points.add(point);
        return point;
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
