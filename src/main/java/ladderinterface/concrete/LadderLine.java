package ladderinterface.concrete;

import ladderinterface.engine.Line;

import java.util.List;

public class LadderLine implements Line {
    private final List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine of(List<Point> points) {
        return new LadderLine(points);
    }

    @Override
    public int move(int point) {
        return points.get(point).move();
    }
}
