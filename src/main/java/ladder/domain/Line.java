package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Line {
    private List<Point> points = new ArrayList<>();

    public Line(int countOfPerson) {
        lineGenerator(countOfPerson);
    }

    public Line(List<Point> points) {
        this.points = points;
    }

    private void lineGenerator(int countOfPerson) {
        Random random = new Random();
        points.add(new Point(random.nextBoolean()));

        for (int i = 1; i < countOfPerson; i++) {
            if (points.get(i - 1).isTrue()) {
                points.add(new Point(false, points.get(i - 1)));
                continue;
            }
            points.add(new Point(true, points.get(i - 1)));
        }
    }

    public boolean hasLine() {
        return points.contains(new Point(true));
    }

    public String drawLine() {
        return points.stream()
                .map(point -> drawLine(point))
                .collect(Collectors.joining());
    }

    private String drawLine(Point point) {
        if (isFirstPoint(point)) {
            return "|" + point.drawPoint();
        }

        if (isLastPoint(point)) {
            return point.drawPoint() + "|";
        }

        return "|" + point.drawPoint() + "|";
    }

    private boolean isFirstPoint(Point point) {
        return points.get(0).equals(point);
    }

    private boolean isLastPoint(Point point) {
        return points.get(points.size() - 1).equals(point);
    }

    public boolean isOverSize(int position) {
        return points.size() <= position;
    }

    public boolean isLessSize(int position) {
        return position < 0;
    }

    public boolean pointStatus(int position) {
        return points.get(position).isTrue();
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
