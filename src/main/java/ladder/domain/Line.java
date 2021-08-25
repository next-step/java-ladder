package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import static ladder.util.LadderPointGenerator.generatePoint;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(List<Boolean> booleans) {
        List<Point> points = new ArrayList<>();
        Direction direction = Direction.first(booleans.get(0));
        points.add(0, new Point(0, direction));
        for(int i=1; i< booleans.size(); i++){
            points.add(i, new Point(i, direction.next(booleans.get(i))));
            direction = direction.next(booleans.get(i));
        }
        points.add(booleans.size(), new Point(booleans.size(), direction.last()));
        return new Line(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static Line init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new Line(points);
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

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(generatePoint());
        points.add(point);
        return point;
    }

    public boolean isRight(int index){
        return points.get(index).isRight();
    }

    public int size(){
        return points.size();
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
