package ladder.engine.impl;

import ladder.engine.Line;

import java.util.List;

class DefaultLine implements Line {
    private final List<Point> points;

    DefaultLine(List<Point> points) {
        this.points = points;
    }

    @Override
    public int move(int position) {
        return points.get(position).move();
    }

    @Override
    public String toString() {
        return "DefaultLine{" +
                "points=" + points +
                '}';
    }
}

