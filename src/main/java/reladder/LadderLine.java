package reladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLine {

    private static final int BOUNDARY_INDEX = 1;

    private List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int index) {
        return this.points.get(index).move();
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = Point.firstNext(new Random().nextBoolean());
        points.add(point);

        for (int i = BOUNDARY_INDEX; i < sizeOfPerson - BOUNDARY_INDEX; i++) {
            point = point.next();
            points.add(point);
        }
        points.add(point.lastNext());
        return new LadderLine(points);
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }
}
