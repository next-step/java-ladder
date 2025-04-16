package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final Points points;
    private final PointStrategy strategy;

    public Line(int countOfPlayer) {
        this(countOfPlayer, new RandomPointStrategy());
    }

    public Line(int countOfPlayer, PointStrategy strategy) {
        this.points = new Points();
        this.strategy = strategy;
        IntStream.range(0, countOfPlayer - 1)
                .forEach(this::appendPoint);
    }

    private void appendPoint(int idx) {
        this.points.add(draw(idx));
    }

    private Point draw(int idx) {
        if (canDraw(idx)) {
            return new Point(strategy.shouldDraw());
        }
        return new Point(false);
    }

    private boolean canDraw(int idx) {
        if (idx == 0) {
            return true;
        }
        return points.canDrawNext(idx);
    }

    public List<Point> getPoints() {
        return points.getPoints();
    }

    public int move(int idx) {
        if (points.canGoLeft(idx)) {
            return --idx;
        }
        if (points.canGoRight(idx)) {
            return ++idx;
        }
        return idx;
    }

}
