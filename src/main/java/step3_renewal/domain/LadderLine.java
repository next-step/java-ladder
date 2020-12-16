package step3_renewal.domain;


import java.util.ArrayList;
import java.util.List;

public class LadderLine {

    private List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(new LadderRandomGenerator().nextLine());
        points.add(point);
        return point;
    }

    private static Point initBody(Point point, LadderRandomGenerator ladderRandomGenerator) {
        return point.next(ladderRandomGenerator.nextLine());
    }

    public static LadderLine init(int sizeOfPerson, LadderRandomGenerator ladderRandomGenerator) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = initBody(point, ladderRandomGenerator);
            points.add(point);
        }
        points.add(point.last());

        return new LadderLine(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public List<Point> getPoints() {
        return points;
    }
}
