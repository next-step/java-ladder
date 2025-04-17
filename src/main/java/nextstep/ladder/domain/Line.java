package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random rand = new Random();
    private final List<Point> points;

    public Line(int count) {
        points = new ArrayList<>();
        Point point = new Point(rand.nextBoolean());
        points.add(point);

        for (int i = 1; i < count - 1; i++) {
            point = point.next(rand.nextBoolean());
            points.add(point);
        }

        points.add(new Point(false)); // 마지막은 오른쪽 선이 없음
    }

    public List<Point> getPoints() {
        return points;
    }
}
