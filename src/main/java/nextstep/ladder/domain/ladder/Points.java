package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Points {

    private static final int MINIMUM_POINT_SIZE = 2;

    private final List<Point> points;

    private Points(int maxPoint, DirectionPredicate predicate) {
        validate(maxPoint);
        this.points = createPoints(maxPoint, predicate);
    }

    public List<Point> getPoints() {
        return points;
    }

    public int size() {
        return points.size();
    }

    public static Points newInstance(int maxPoint, DirectionPredicate predicate) {
        return new Points(maxPoint, predicate);
    }

    private List<Point> createPoints(int maxPoint, DirectionPredicate predicate) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(Direction.generate(predicate)));

        IntStream.range(1, maxPoint)
                .boxed()
                .map(index -> Point.createPoint(index == maxPoint - 1, predicate, points.get(index - 1)))
                .forEach(points::add);

        return points;
    }

    private void validate(int maxPoint) {
        if (maxPoint < MINIMUM_POINT_SIZE) {
            throw new IllegalArgumentException("사다리 위치 리스트의 최소 크기는 " + MINIMUM_POINT_SIZE + "입니다.");
        }
    }
}
