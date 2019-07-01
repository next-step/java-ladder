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
        for (int i = 0; i < countByPlayers - 2; i++) {
            points.add(generateNextPoint(points.get(i), pointStrategy));
        }
    }

    private Point generateNextPoint(Point before, PointStrategy pointStrategy) {
        if (before.isRight()) {
            return POINT_LEFT;
        }
        return Point.of(NO_MOVABLE, pointStrategy.generate());
    }

    private void generateLast(PointStrategy pointStrategy) {
        points.add(Point.of(pointStrategy.generate(), NO_MOVABLE));
    }
}