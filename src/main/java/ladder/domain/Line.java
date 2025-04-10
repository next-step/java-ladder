package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random RANDOM = new Random();
    private final List<Point> points;

    public Line(int countOfUser) {
        this.points = new ArrayList<>();
        for (int i = 0; i < countOfUser - 1; i++) {
            points.add(draw(i));
        }
    }

    private Point draw(int idx) {
        if (canDraw(idx)) {
            return new Point(RANDOM.nextBoolean());
        }
        return new Point(false);
    }

    private boolean canDraw(int idx) {
        if (idx == 0) {
            return true;
        }
        return !points.get(idx - 1).hasPoint();
    }

    public List<Point> getPoints() {
        return List.copyOf(points);
    }

}
