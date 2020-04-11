package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 사다리 한 Line 추상화
 * 사다리 게임에서 한 Line을 LadderLine으로 이름을 붙이고 다음과 같이 구현
 * 사다리 Line의 모든 Point 초기화와 이동을 담당
 */
public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine of(int personSize) {
        List<Point> points = new ArrayList<>();
        Point createdPoint = Point.first();
        createdPoint = addMiddlePoints(personSize, points, createdPoint);
        points.add(Point.last(createdPoint));
        return new LadderLine(points);
    }

    private static Point addMiddlePoints(int personSize, List<Point> points, Point createdPoint) {
        points.add(createdPoint);
        for (int i = 1; i < personSize - 1; i++) {
            createdPoint = Point.middle(createdPoint);
            points.add(createdPoint);
        }
        return createdPoint;
    }

    public int move(int i) {
        return points.get(i).move();
    }

    public List<Point> getPoints() {
        return points;
    }
}
