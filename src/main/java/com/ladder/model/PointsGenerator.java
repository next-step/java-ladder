package com.ladder.model;

import java.util.ArrayList;
import java.util.List;

public class PointsGenerator {

    private final PointStrategy pointStrategy;
    private List<Boolean> points = new ArrayList<>();

    PointsGenerator() {
        this.pointStrategy = new PointRandomStrategy();
    }

    PointsGenerator(PointStrategy pointStrategy) {
        this.pointStrategy = pointStrategy;
    }

    List<Boolean> generate(int countByPlayers) {
        points.add(pointStrategy.generate());
        for (int i = 1; i < countByPlayers - 1; i++) {
            Boolean beforePoint = points.get(i - 1);
            generateNextPoint(beforePoint);
        }
        generateEndPoint();
        return points;
    }

    private void generateNextPoint(boolean before) {
        if (before) {
            points.add(false);
            return;
        }
        points.add(pointStrategy.generate());
    }

    private void generateEndPoint() {
        points.add(false);
    }
}
