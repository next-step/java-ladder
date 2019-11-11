package game.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by yusik on 2019/11/09.
 */
public class Line {

    private List<Point> points = new ArrayList<>();
    private Random random = new Random();

    public Line(int countOfPerson) {
        Point prevPoint = new Point(false);
        for (int i = 0; i < countOfPerson - 1; i++) {
            Point point = prevPoint.movable() ? new Point(false) : new Point(random.nextBoolean());
            points.add(point);
            prevPoint = point;
        }
        points.add(new Point(false));
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
