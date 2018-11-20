package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line() {
        points = new ArrayList<>();
    }

    private Line(List<Boolean> points) {
        this.points = points;
    }

    private Line(int countOfPerson) {
        points = new ArrayList<>();

        drawLines(countOfPerson);
    }

    public static Line of(List<Boolean> points) {
        return new Line(points);
    }

    public static Line of(int countOfPerson) {
        return new Line(countOfPerson);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int size() {
        return points.size();
    }

    public Line drawLines(int countOfPerson) {
        for(int i = 0; i < countOfPerson; i++) {
            boolean line = getPoint(i);
            draw(line);
        }
        return this;
    }

    public void draw(boolean line) {
        validation(line);
        points.add(line);
    }

    private void validation(boolean line) {
        if(points.size() == 0) {
            return;
        }

        boolean lastPoint = prevPoint(points.size());
        if(lastPoint && lastPoint == line) {
            throw new IllegalArgumentException();
        }
    }
    private boolean getPoint(int i) {
        return prevPoint(i) ? false : RandomUtil.getRandomBoolean();
    }

    private Boolean prevPoint(int i) {
        if(i == 0) {
            return true;
        }
        return points.get(i - 1);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return points != null ? points.equals(line.points) : line.points == null;
    }

    @Override
    public int hashCode() {
        return points != null ? points.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
