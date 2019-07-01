package com.jaeyeonling.ladder.domain.line;

import com.jaeyeonling.ladder.domain.point.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Direction> directions;

    private Line(final List<Direction> directions) {
        this.directions = new ArrayList<>(directions);
    }

    public static Line ofDirections(final List<Direction> directions) {
        return new Line(directions);
    }

    public List<Direction> getDirections() {
        return Collections.unmodifiableList(directions);
    }
}
