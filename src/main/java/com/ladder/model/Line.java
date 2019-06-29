package com.ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    private Line(List<Boolean> point) {
        this.points = new ArrayList<>(point);
    }

    public static Line of(int numberOfPoints) {
        PointsGenerator pointsGenerator = new PointsGenerator();
        return new Line(pointsGenerator.generate(numberOfPoints));
    }

    public static Line of(int numberOfPoints, PointStrategy pointStrategy) {
        PointsGenerator pointsGenerator = new PointsGenerator(pointStrategy);
        return new Line(pointsGenerator.generate(numberOfPoints));
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
