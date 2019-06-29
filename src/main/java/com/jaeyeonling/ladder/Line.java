package com.jaeyeonling.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    private Line(final List<Boolean> points) {
        this.points = points;
    }

    public static Line of(final int countOfPerson) {
        final List<Boolean> points = new ArrayList<>();

        return new Line(points);
    }
}
