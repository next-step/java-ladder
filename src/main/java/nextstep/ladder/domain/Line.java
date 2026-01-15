package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Boolean> connections) {
        this.points = createPoints(connections);
    }

    private List<Point> createPoints(List<Boolean> connections) {
        List<Point> points = new ArrayList<>();

        Point point = Point.first(connections.isEmpty() ? false : connections.get(0));
        points.add(point);

        for (int i = 1; i < connections.size(); i++) {
            point = point.next(connections.get(i));
            points.add(point);
        }

        points.add(point.last());
        return points;
    }

    public Line(int countOfPerson) {
        this.points = generatePoints(countOfPerson);
    }

    private List<Point> generatePoints(int countOfPerson) {
        List<Point> points = new ArrayList<>();

        Point point = Point.first(generateRandomBoolean(false));
        points.add(point);

        for (int i = 1; i < countOfPerson - 1; i++) {
            point = point.next(generateRandomBoolean(point.hasRightConnection()));
            points.add(point);
        }

        points.add(point.last());
        return points;
    }

    private boolean generateRandomBoolean(boolean previousRight) {
        if (previousRight) {
            return false;
        }
        return Math.random() < 0.5;
    }

    public boolean hasConnectionAt(int position) {
        return points.get(position).hasRightConnection();
    }

    public int move(int position) {
        return points.get(position).move();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("     ");
        for (int i = 0; i < points.size() - 1; i++) {
            sb.append("|").append(points.get(i).hasRightConnection() ? "-----" : "     ");
        }
        sb.append("|");
        return sb.toString();
    }
}