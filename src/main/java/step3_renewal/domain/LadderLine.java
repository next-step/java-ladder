package step3_renewal.domain;


import java.util.ArrayList;
import java.util.List;

public class LadderLine {

    private List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    private static Point initFirst(List<Point> points, LadderGenerator ladderGenerator) {
        Point point = Point.first(ladderGenerator.nextLine());
        points.add(point);
        return point;
    }

    private static Point initBody(Point point, LadderGenerator ladderGenerator) {
        return point.next(ladderGenerator.nextLine());
    }

    public static LadderLine init(int sizeOfPerson, LadderGenerator ladderGenerator) {
        List<Point> points = new ArrayList<>(sizeOfPerson);
        Point point = initFirst(points, ladderGenerator);
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = initBody(point, ladderGenerator);
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

    public int getPointSize() {
        return points.size();
    }
}
