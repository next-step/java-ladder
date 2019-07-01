package com.ladder.model;

import java.util.ArrayList;
import java.util.List;

import static com.ladder.model.Point.NO_MOVABLE;
import static com.ladder.model.Point.POINT_LEFT;

public class PointsGenerator {

    private List<Point> points = new ArrayList<>();

    List<Point> generate(int countByPlayers, PointStrategy pointStrategy) {
        generateFirst(pointStrategy);
        generateMiddle(countByPlayers, pointStrategy);
        generateLast(pointStrategy);
        return points;
    }

    private void generateFirst(PointStrategy pointStrategy) {
        points.add(Point.ofFirst(pointStrategy.generate()));
    }

    private void generateMiddle(int countByPlayers, PointStrategy pointStrategy) {
        Point before = points.get(0);
        for (int i = 1; i < countByPlayers - 1; i++) {
            if (before.isRight()) {
                points.add(POINT_LEFT);
                continue;
            }
            points.add(Point.of(pointStrategy.generate(), pointStrategy.generate()));
        }
    }

    private void generateLast(PointStrategy pointStrategy) {
        points.add(Point.of(pointStrategy.generate(), NO_MOVABLE));
    }
}
