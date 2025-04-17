package ladder;

import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public int move(int index) {
        if (canMoveLeft(index)) return index - 1;
        if (canMoveRight(index)) return index + 1;
        return index;
    }

    public boolean canMoveLeft(int index) {
        return index > 0 && points.get(index - 1).hasRight();
    }

    public boolean canMoveRight(int index) {
        return index < points.size() && points.get(index).hasRight();
    }

}