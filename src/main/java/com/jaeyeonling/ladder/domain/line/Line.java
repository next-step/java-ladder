package com.jaeyeonling.ladder.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    private Line(final List<Boolean> points) {
        this.points = new ArrayList<>(points);
    }

    public static Line ofPoints(final List<Boolean> points) {
        return new Line(points);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
