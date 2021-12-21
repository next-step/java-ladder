package nextstep.ladder.domain;

import nextstep.ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 사다리 한 Line 추상화
 *  - 사다리 게임에서 한 Line을 LadderLine으로 이름을 붙이고 다음과 같이 구현
 *  - 사다리 Line의 모든 Point 초기화와 이동을 담당
 */
public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson, PointStrategy pointStrategy) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, pointStrategy);
        point = initBody(sizeOfPerson, points, point, pointStrategy);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point, PointStrategy pointStrategy) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(pointStrategy);
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(List<Point> points, PointStrategy pointStrategy) {
        Point point = Point.first(pointStrategy.generatePoint());
        points.add(point);
        return point;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
