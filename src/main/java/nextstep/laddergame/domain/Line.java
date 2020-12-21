package nextstep.laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points;
    private MovingStrategy movingStrategy;

    public Line(int length) {
        this.movingStrategy = new RandomStrategy();
        List<Point> points = new ArrayList<>();

        Point point = Point.createFirst(this.movingStrategy);
        points.add(point);
        for (int index = 1; index < length - 1; index++) {
            point = Point.createWithBeforePoint(point, this.movingStrategy);
            points.add(point);
        }
        points.add(Point.createLastWithBeforePoint(point));

        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public int moveByIndex(int index) {
        Point point = findPointByIndex(index);

        return point.move();
    }

    private Point findPointByIndex(int index) {
        return this.points.stream().filter(point -> point.isEqualTo(index))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("index 범위를 초과하였습니다."));
    }
}
