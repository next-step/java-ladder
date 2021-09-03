package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LadderLine {
    private static final int START_INDEX = 1;
    private List<Point> points;

    public LadderLine(List<Point> points) {
        if (points.get(points.size() - 1).nextPoint()) {
            throw new IllegalArgumentException("올바른 사다리가 아닙니다");
        }
        this.points = points;
    }

    public static LadderLine init(int countOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points); // 첫 번째 가로 라인 초기화
        point = createBody(countOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    public static Point initFirst(List<Point> points) {
        Point point = Point.init(RandomUtil.generate());
        points.add(point);
        return point;
    }

    private static Point createBody(int countOfPerson, List<Point> points, Point point) {
        for (int i = START_INDEX; i < countOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }


    public int search(int index) {
        Direction direction = new Direction(index);
        int point = points.get(index).move();
        return direction.move(point);
    }

    public int size() {
        return points.size();
    }

    public Stream<Point> stream() {
        return points.stream();
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
