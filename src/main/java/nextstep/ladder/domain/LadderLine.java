package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private static final int MIN_SIZE_OF_PERSON = 2;

    private List<Point> points;

    public LadderLine(List<Point> points) {
        validNotEmptyPoints(points);
        this.points = points;
    }

    private void validNotEmptyPoints(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("포인트 목록이 비었습니다.");
        }
    }

    public static LadderLine init(int sizeOfPerson, LadderGenerator ladderGenerator) {
        if (sizeOfPerson < MIN_SIZE_OF_PERSON) {
            throw new IllegalArgumentException("플레이어는 최소 " + MIN_SIZE_OF_PERSON + "명 이상 이어야 합니다.");
        }
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, ladderGenerator);
        point = initBody(sizeOfPerson, points, point, ladderGenerator);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point, LadderGenerator ladderGenerator) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(ladderGenerator);
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(List<Point> points, LadderGenerator ladderGenerator) {
        Point point = Point.first(ladderGenerator.randomGenerate());
        points.add(point);
        return point;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public List<Point> getPoints() {
        return points;
    }
}
