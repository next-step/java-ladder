package domain;

import java.util.List;
import java.util.function.Consumer;

public class Points {
    private final List<Point> points;

    public Points(final List<Point> points) {
        this.points = points;
    }

    public int move(int index) {
        return points.get(index).move();
    }

    public void forEachPoint(Consumer<? super Point> consumer) {
        points.forEach(consumer);
    }
}
