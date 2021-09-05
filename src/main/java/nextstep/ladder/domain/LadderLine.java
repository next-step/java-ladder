package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LadderLine {
    private static final int START_INDEX = 1;
    private List<Point> points;

    public LadderLine(List<Point> points) {
        validLadderLine(points);
        this.points = points;
    }

    public static LadderLine init(int countOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = createBody(countOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initFirst(List<Point> points) {
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

    private void validLadderLine(List<Point> points) {
        int lastIndex = points.size() - 1;
        if (points.get(lastIndex).isNext()) {
            throw new IllegalArgumentException("마지막 라인의 오른쪽에는 가로 선이 올 수 없습니다.");
        }
    }



    public int move(int index) {
        return points.get(index).move();
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
