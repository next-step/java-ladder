package nextstep.step4;

import java.util.ArrayList;
import java.util.List;

import static nextstep.step4.LadderPointGenerator.generatePoint;

public class LadderLine {

    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
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

    public String drawLine() {

        String resultLine = "";

        for (Point point : points) {
            resultLine += point.drawLine();
        }
        return resultLine;
    }

    public List<Integer> movePoints() {

        List<Integer> arrivePoints = new ArrayList<>();

        for (int i = 0; i < points.size(); i++) {
            arrivePoints.add(this.move(i));
        }


        return arrivePoints;
    }


    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
