package com.jaeyeonling.ladder.domain.line;

import com.jaeyeonling.ladder.domain.point.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Lines {

    private final List<Line> lines;

    private Lines(final List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public static Lines of(final List<Line> lines) {
        return new Lines(lines);
    }

    public Stream<Line> stream() {
        return lines.stream();
    }

    public Point ride(Point point) {
        while (isNotArriveEndLine(point)) {
            point = rideOnce(point);
        }

        return point;
    }

    private boolean isNotArriveEndLine(final Point point) {
        return point.getIndexOfLine() != lines.size();
    }

    private Point rideOnce(final Point point) {
        return lines.get(point.getIndexOfLine())
                .ride(point);
    }
}
