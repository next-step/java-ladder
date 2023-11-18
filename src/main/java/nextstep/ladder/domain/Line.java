package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = new ArrayList<>(points);
    }

    public Line(int count) {
        this(Collections.nCopies(count, Boolean.FALSE));
    }

    public boolean canDraw(int index) {
        boolean previous = hasPreviousLine(index);
        boolean next = hasNextLine(index);

        return !previous && !next;
    }

    private boolean hasNextLine(int index) {
        return index < points.size() - 1 && points.get(index + 1);
    }

    private boolean hasPreviousLine(int index) {
        return index > 0 && points.get(index - 1);
    }

    public void draw(int index,
                     boolean maybeDraw) {
        this.points.set(index, maybeDraw);
    }

    public List<Boolean> getAll() {
        return this.points;
    }

    public Direction nextDirection(int point) {
        if (canMoveRight(point)) {
            return Direction.RIGHT;
        }
        if (canMoveLeft(point)) {
            return Direction.LEFT;
        }
        return Direction.STAY;
    }

    private boolean canMoveRight(int point) {
        return point < points.size() && points.get(point);
    }

    private boolean canMoveLeft(int point) {
        return point > 0 && points.get(point - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
