package nextstep.step4.impl;

import nextstep.step4.engine.Line;

import java.util.List;
import java.util.stream.Collectors;

public class SimpsonLine implements Line {
    private static final String DELIMITER_STR = "|";
    private List<Point> points;

    public SimpsonLine(final List<Point> points) {
        this.points = points;
    }

    @Override
    public int move(final int position) {
        final Point point = points.get(position);
        return point.move(position);
    }

    @Override
    public String toString() {
        return this.points.stream()
                .map(p -> DELIMITER_STR + p.toString())
                .collect(Collectors.joining());
    }
}
