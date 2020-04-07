package ladder.domain;

import java.util.Collections;
import java.util.List;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.RIGHT;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        for (int i = 0 ; i < points.size() - 1 ; i++) {
            checkValidation(points.get(i), points.get(i + 1));
        }
        this.points = Collections.unmodifiableList(points);
    }

    private void checkValidation(Point point, Point nextPoint) {
        if (point.isConnectedTo(LEFT) && nextPoint.isConnectedTo(LEFT)) {
            throw new IllegalArgumentException("바로 옆에 있는 점들은 같은 방향으로 연결될 수 없다");
        }

        if (point.isConnectedTo(RIGHT) && nextPoint.isConnectedTo(RIGHT)) {
            throw new IllegalArgumentException("바로 옆에 있는 점들은 같은 방향으로 연결될 수 없다");
        }
    }

    public static Line of(List<Point> points) {
        return new Line(points);
    }

    public List<Point> getPoints() {
        return points;
    }

    public int width() {
        return points.size();
    }
}
