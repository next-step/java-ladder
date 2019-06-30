package com.jaeyeonling.ladder.domain.line;

import java.util.List;

public class Line {

    private final List<Boolean> points;

    private Line(final List<Boolean> points) {
        this.points = points;
    }

    public static Line ofPoints(final List<Boolean> points) {
        return new Line(points);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
