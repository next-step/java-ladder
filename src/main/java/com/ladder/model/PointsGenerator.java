package com.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.ladder.model.Direction.DOWN;
import static com.ladder.model.Direction.RIGHT;

public class PointsGenerator {

    private List<Point> points = new ArrayList<>();

    List<Point> generate(int countByPlayers, PointStrategy pointStrategy) {
        generateFirst(pointStrategy);
        generateMiddle(countByPlayers, pointStrategy);
        generateLast();
        return points;
    }

    private void generateFirst(PointStrategy pointStrategy) {
        Direction direction = pointStrategy.generate() ? RIGHT : DOWN;
        points.add(Point.ofFirst(direction));
    }

    private void generateMiddle(int countByPlayers, PointStrategy pointStrategy) {
        IntStream.range(0, countByPlayers - 2)
                .mapToObj(index -> generateNextPoint(points.get(index), pointStrategy))
                .forEach(points::add);
    }

    private Point generateNextPoint(Point before, PointStrategy pointStrategy) {
        if (before.isRight()) {
            return before.next(Direction.LEFT);
        }
        Direction direction = pointStrategy.generate() ? RIGHT : DOWN;
        return before.next(direction);
    }

    private void generateLast() {
        Point lastBeforePoint = points.get(points.size() - 1);
        points.add(lastBeforePoint.last());
    }
}