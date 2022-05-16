package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.HorizontalStrategy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int FIRST_SIZE = 0;

    private final LinkedList<Boolean> points;

    public Line() {
        this.points = new LinkedList<>();
    }

    public void add(HorizontalStrategy horizonStrategy) {
        points.add(horizonStrategy.canHorizontal());
    }

    public boolean isLeft() {
        if (isFirst()) {
            return false;
        }
        return points.getLast();
    }

    public boolean isSamePointSize(Line line) {
        return this.points.size() == line.points.size();
    }

    private boolean isFirst() {
        return points.size() == FIRST_SIZE;
    }

    public List<Boolean> getPoints(){
        return Collections.unmodifiableList(points);
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

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
