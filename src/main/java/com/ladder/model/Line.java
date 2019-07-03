package com.ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Point> points;

    private Line(List<Point> point) {
        this.points = new ArrayList<>(point);
    }

    static Line ofPoints(List<Point> points) {
        return new Line(new ArrayList<>(points));
    }

    static Line of(int countByPlayers) {
        PointStrategy pointStrategy = new RandomPointStrategy();
        return ofWithStrategy(countByPlayers, pointStrategy);
    }

    static Line ofWithStrategy(int countByPlayers, PointStrategy pointStrategy) {
        PointsGenerator pointsGenerator = new PointsGenerator();
        return new Line(pointsGenerator.generate(countByPlayers, pointStrategy));
    }

    Position move(Position position) {
        return points.get(position.getPosition()).move();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
