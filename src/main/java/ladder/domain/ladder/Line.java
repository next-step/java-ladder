package ladder.domain.ladder;

import java.util.List;

public final class Line {

    private final List<Point> line;

    public Line(List<Point> line) {
        this.line = line;
    }

//    public static final Line of(int sizeOfPerson) {
//        return of(init(sizeOfPerson));
//    }
//
//    private static List<Point> init(int sizeOfPerson) {
//        List<Point> points = new ArrayList<>();
//        Point point = initFirst(points);
//        point = initBody(sizeOfPerson, points, point);
//        initLast(points, point);
//        return new LadderLine(points);
//    }
//
//    public static final Line of(List<Point> line) {
//        return null;
//    }
//
//    private static final Point initBody(int sizeOfPerson, List<Point> points, Point point) {
//        for (int i = 1; i < sizeOfPerson - 1; i++) {
//            point = point.next();
//            points.add(point);
//        }
//        return point;
//    }
//
//    private static void initLast(List<Point> points, Point point) {
//        point = point.last();
//        points.add(point);
//    }
//
//    private static Point initFirst(List<Point> points) {
//        Point point = Point.first(generatePoint());
//        points.add(point);
//        return point;
//    }

}
