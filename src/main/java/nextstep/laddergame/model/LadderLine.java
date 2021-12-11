package nextstep.laddergame.model;

import java.util.ArrayList;
import java.util.List;

import nextstep.laddergame.utils.RandomUtils;

public class LadderLine {

    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine init(int sizeOfParticipants) {
        List<Point> points = new ArrayList<>();
        Point first = initFirst(points);
        Point lastBody = initBody(sizeOfParticipants, points, first);
        initLast(points, lastBody);
        return new LadderLine(points);
    }

    private static Point initFirst(List<Point> points) {
        Point first = Point.first(RandomUtils.generateDirection());
        points.add(first);
        return first;
    }

    private static Point initBody(int sizeOfParticipants, List<Point> points, Point point) {
        for (int i = 1; i < sizeOfParticipants - 1; i++) {
            point = point.next(RandomUtils.generateDirection());
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point lastBody) {
        points.add(lastBody.last());
    }

    public int move(int position) {
        return points.get(position).move();
    }
}
