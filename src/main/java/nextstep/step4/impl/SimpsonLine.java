package nextstep.step4.impl;

import nextstep.step4.engine.Line;

import java.util.List;

public class SimpsonLine implements Line {
    private List<Point> points;

    public SimpsonLine(final List<Point> points) {
        this.points = points;
    }

    @Override
    public int move(final int position) {
        final Point point = points.get(position);
        return point.move(position);
    }
}
