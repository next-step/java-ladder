/*
 * 사다리의 가로줄을 의미하며 각 점의 초기화와 이동을 관리하는 클래스
 * */
package step4.laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine init(int numberOfPeople, LadderPointerGenerator generator) {
        List<Point> points = new ArrayList<>();
        initFirst(points, generator);
        initBody(numberOfPeople, points, generator);
        initLast(points);
        return new LadderLine(points);
    }

    private static void initLast(List<Point> points) {
        Point point = points.get(points.size() - 1);
        points.add(point.last());
    }

    private static void initBody(int numberOfPeople, List<Point> points, LadderPointerGenerator generator) {
        Point point = points.get(points.size() - 1);
        for (int i = 1; i < numberOfPeople - 1; i++) {
            point = point.next(generator);
            points.add(point);
        }
    }

    private static void initFirst(List<Point> points, LadderPointerGenerator generator) {
        Point point = Point.first(generator.generatePoint());
        points.add(point);
    }

    public int move(int index) {
        return points.get(index).move();
    }

    public List<Boolean> isConnect() {
        return points.stream()
                .map(Point::isLinkedLeft)
                .collect(Collectors.toList());
    }

    public int size() {
        return points.size();
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

}
