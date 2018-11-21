package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points;

    private Line(List<Boolean> points) {
        validation(points);

        this.points = points;
    }

    public static Line of(List<Boolean> points) {
        return new Line(points);
    }

    public static Line of(int countOfPerson) {
        List<Boolean> points = drawLines(countOfPerson);
        return new Line(points);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int size() {
        return points.size();
    }


    public static List<Boolean> drawLines(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();

        for(int i = 0; i < countOfPerson; i++) {
            boolean line = lastPoint(points) ? false : RandomUtil.getRandomBoolean();
            points.add(line);
        }
        return points;
    }

    private static Boolean lastPoint(List<Boolean> points) {
        if(points.size() == 0) {
            return true;
        }
        return points.get(points.size() - 1);
    }

    private void validation(List<Boolean> points) {
        for(int i = 1; i < points.size(); i++) {
            validationPoint(points, i);
        }
    }

    private void validationPoint(List<Boolean> points, int i) {
        if(points.get(i - 1) && points.get(i)) {
            throw new IllegalArgumentException();
        }
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
