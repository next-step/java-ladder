package step3_renewal.domain;


import java.util.ArrayList;
import java.util.List;

public class LadderLine {

    private List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine init(int sizeOfPerson, LadderRandomGenerator ladderRandomGenerator) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        initBody(sizeOfPerson, points, point, ladderRandomGenerator);
        return new LadderLine(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(new LadderRandomGenerator().nextLine());
        points.add(point);
        return point;
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point, LadderRandomGenerator ladderRandomGenerator) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(ladderRandomGenerator.nextLine());
            points.add(point);
        }
        points.add(point.last());

        return point;
    }

    public List<Point> getPoints() {
        return points;
    }
}
