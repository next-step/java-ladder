package com.ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Point> points;

    private Line(List<Point> point) {
        this.points = new ArrayList<>(point);
    }

    static Line of(int countByPlayers) {
        PointStrategy pointStrategy = new PointRandomStrategy();
        return of(countByPlayers, pointStrategy);
    }

    static Line of(int countByPlayers, PointStrategy pointStrategy) {
        PointsGenerator pointsGenerator = new PointsGenerator();
        return new Line(pointsGenerator.generate(countByPlayers, pointStrategy));
    }

    List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
