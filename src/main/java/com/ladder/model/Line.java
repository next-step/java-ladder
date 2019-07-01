package com.ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    private Line(List<Boolean> point) {
        this.points = new ArrayList<>(point);
    }

    public static Line of(int countByPlayers) {
        PointStrategy pointStrategy = new PointRandomStrategy();
        List<Boolean> points = ofPoints(countByPlayers, pointStrategy);
        return new Line(points);
    }

    private static List<Boolean> ofPoints(int countByPlayers, PointStrategy pointStrategy) {
        List<Boolean> points = new ArrayList<>();
        points.add(pointStrategy.generate());
        for (int i = 1; i < countByPlayers - 1; i++) {
            Boolean beforePoint = points.get(i - 1);
            generateNextPoint(points, beforePoint, pointStrategy);
        }
        generateEndPoint(points);
        return points;
    }

    public static Line of(int countByPlayers, PointStrategy pointStrategy) {
        List<Boolean> points = ofPoints(countByPlayers, pointStrategy);
        return new Line(points);
    }

    private static void generateNextPoint(List<Boolean> points, boolean before, PointStrategy pointStrategy) {
        if (before) {
            points.add(false);
            return;
        }
        points.add(pointStrategy.generate());
    }

    private static void generateEndPoint(List<Boolean> points) {
        points.add(false);
    }


    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
