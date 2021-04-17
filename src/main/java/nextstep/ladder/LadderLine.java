package nextstep.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderLine {
    private final static int MIN_LENGTH = 2;
    private final List<Point> points;

    private LadderLine(List<Point> points) {
        validation(points);
        this.points = points;
    }

    private void validation(List<Point> points) {
        if (points.size() < MIN_LENGTH) {
            throw new IllegalArgumentException("최소 좌표 생성 개수는 2개 이상이어야 합니다.");
        }
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson, DrawRule drawRule) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, drawRule);
        point = initBody(sizeOfPerson, points, point, drawRule);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point, DrawRule drawRule) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(drawRule);
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(List<Point> points, DrawRule drawRule) {
        Point point = Point.first(drawRule.isDrawable());
        points.add(point);
        return point;
    }

    public List<Point> points() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
