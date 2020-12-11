package ladder.model.ladder;

import ladder.model.move.Point;
import ladder.view.LadderItem;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static Line from(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new Line(points);
    }

    public int size(){
        return points.size();
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
        Point point = Point.first(RandomUtils.trueOrFalse());
        points.add(point);
        return point;
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder(LadderItem.VERTICAL.getItem());
        IntStream.range(0, points.size()-1).boxed()
                .map(points::get)
                .map(this::partOfLine)
                .forEach(line::append);

        return line.toString();
    }

    private String partOfLine(Point point) {
        return point.toString() + LadderItem.VERTICAL.getItem();
    }
}
