package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLine {
    private final static int THIRD_ELEMENT_INDEX = 2;

    private List<Point> points;

//    LadderLine(int countOfPerson) {
//        Random random = new Random();
//        points = new ArrayList<>();
////        points.add(new Point(false));
////        points.add(new Point(random.nextBoolean()));
////
////        IntStream.range(THIRD_ELEMENT_INDEX, countOfPerson).forEach(i -> {
////            Point pointElement = new Point(random.nextBoolean());
////            points.add(points.get(i - 1).checkDuplicate(pointElement)); // 세번째 요소부터 중복체크
////        });
//
//    }

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);

    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(generatePoint());
        points.add(point);
        return point;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    private static Boolean generatePoint() {
        return new Random().nextBoolean();
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return true;
    }


}
