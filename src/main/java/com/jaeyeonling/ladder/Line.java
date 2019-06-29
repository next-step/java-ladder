package com.jaeyeonling.ladder;

import java.util.List;

public class Line {

    private final List<Boolean> points;

    private Line(final List<Boolean> points) {
        this.points = points;
    }

    public static Line of(final List<Boolean> points) {
        return new Line(points);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
