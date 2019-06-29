package com.ladder.model;

import java.util.ArrayList;
import java.util.List;

public class PointsGenerator {

    private final PointStrategy pointStrategy;

    PointsGenerator() {
        this.pointStrategy = new PointRandomStrategy();
    }

    PointsGenerator(PointStrategy pointStrategy) {
        this.pointStrategy = pointStrategy;
    }

    List<Boolean> generate(int countByPlayers) {
        List<Boolean> points = new ArrayList();
        points.add(pointStrategy.generate());
        for (int i = 1; i < countByPlayers - 1; i++) {
            Boolean beforePoint = points.get(i - 1);
            generateNextPoint(points, beforePoint);
        }
        points.add(false);
        return points;
    }

    private void generateNextPoint(List<Boolean> points, boolean before) {
        if (before) {
            points.add(false);
            return;
        }
        points.add(pointStrategy.generate());
    }
}
