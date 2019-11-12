package game.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by yusik on 2019/11/09.
 */
public class Line {

    private List<Point> points = new ArrayList<>();
    private Random random = new Random();

    public Line(int countOfPlayer) {
        Point prevPoint = Point.of(false);
        for (int i = 0; i < countOfPlayer - 1; i++) {
            Point point = prevPoint.createNextPoint(() -> random.nextBoolean());
            points.add(point);
            prevPoint = point;
        }
        points.add(Point.of(false));
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
