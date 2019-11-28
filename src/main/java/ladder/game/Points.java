package ladder.game;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Points {
    private List<Point> points;

    public Points(int ladderWidth) {
        this.points = IntStream.rangeClosed(0, ladderWidth)
                .boxed()
                .map(Point::of)
                .collect(toList());
    }

    public Points(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public Point get(int index) {
        return points.get(index);
    }
}
