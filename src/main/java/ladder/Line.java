package ladder;

import nextstep.ladder.Direction;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public int move(int index) {
        Direction direction = points.get(index).move();
        if (direction == Direction.LEFT) {
            return index - 1;
        }
        if (direction == Direction.RIGHT) {
            return index + 1;
        }
        return index;
    }

    public int size() {
        return points.size();
    }

    public List<Point> points() {
        return List.copyOf(points);
    }

}