package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LadderLine {
    private static Random random = new Random();
    private final List<ImprovingPoint> points;

    public LadderLine(List<ImprovingPoint> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson) {
        List<ImprovingPoint> points = new ArrayList<>();
        ImprovingPoint point = initFirst(points);
        initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static ImprovingPoint initBody(int sizeOfPerson, List<ImprovingPoint> points,
                                           ImprovingPoint point) {
        for (int i = 0; i < sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<ImprovingPoint> points, ImprovingPoint point) {
        point.last();
        points.add(point);
    }

    private static ImprovingPoint initFirst(List<ImprovingPoint> points) {
        ImprovingPoint point = ImprovingPoint.first(generatePoint());
        points.add(point);
        return point;
    }

    private static Boolean generatePoint() {
        return random.nextBoolean();
    }

    @Override
    public String toString() {
        return "LadderLine{" +
               "points=" + points +
               '}';
    }
}
