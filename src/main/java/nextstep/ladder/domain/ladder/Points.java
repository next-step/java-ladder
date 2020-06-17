package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Points {

    private static final int MINIMUM_POINT_SIZE = 2;

    private final List<Point> points;

    private Points(int sizeOfPerson, DirectionPredicate directionPredicate) {
        validate(sizeOfPerson);
        this.points = init(sizeOfPerson, directionPredicate);
    }

    public List<Point> getPoints() {
        return points;
    }

    public int size() {
        return points.size();
    }

    public int move(int position) {
        return position + points.get(position).move();
    }

    public static Points newInstance(int sizeOfPerson, DirectionPredicate predicate) {
        return new Points(sizeOfPerson, predicate);
    }

    private List<Point> init(int pointSize, DirectionPredicate predicate) {
        List<Point> points = new ArrayList<>();
        Point first = initFirst(predicate);
        points.add(first);
        points.addAll(initBody(first, predicate, pointSize - 2));
        points.add(initLast(points.get(points.size() - 1)));
        return points;
    }

    private Point initFirst(DirectionPredicate predicate) {
        return Point.first(predicate);
    }

    private List<Point> initBody(Point fist, DirectionPredicate predicate, int bodySize) {
        List<Point> points = new ArrayList<>();
        points.add(fist.next(predicate));

        IntStream.range(0, bodySize - 1)
                .mapToObj(points::get)
                .map(point -> point.next(predicate))
                .forEach(points::add);

        return points;
    }

    private Point initLast(Point point) {
        return point.last();
    }

    private void validate(int pointSize) {
        if (pointSize < MINIMUM_POINT_SIZE) {
            throw new IllegalArgumentException("사다리 위치 리스트의 최소 크기는 " + MINIMUM_POINT_SIZE + "입니다.");
        }
    }
}
