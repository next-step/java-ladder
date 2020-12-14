package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Line {

    private final List<Point> points;

    public Line(List<Point> points){
        validatePoints(points);
        this.points = points;
    }

    public static Line init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new Line(points);
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(DirectionGenerator.generateDirection());
        points.add(point);
        return point;
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;

    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    public int move(int moveIndex) {
        return points.get(moveIndex).move();
    }

    private void validatePoints(List<Point> points) {
        points.stream()
                .filter(point -> point.getDirection().isLeft() && point.getDirection().isRight())
                .findAny()
                .ifPresent(point -> {
                    throw new IllegalArgumentException("사다리 가로라인은 겹칠 수 없습니다.");
                });
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }


}
