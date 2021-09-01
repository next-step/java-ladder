package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private List<Point> points;

    public Line(int numberOfUser, LadderStrategy ladderStrategy) {
        points = new ArrayList<>();

        for (int i = 0; i < numberOfUser; i++) {
            drawPoint(ladderStrategy, i);
        }

    }

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Boolean> getLine() {
        List<Boolean> points = new ArrayList<>();

        for (Point point : this.points) {
            points.add(point.getPoint());
        }

        return points;
    }

    private int drawPoint(LadderStrategy ladderStrategy, int index) {
        boolean isPoint = ladderStrategy.generateLine();
        if (index != 0 && getLast()) {
            isPoint = false;
        }

        points.add(new Point(index, isPoint));
        return index;
    }

    public void getResult() {
        List<Point> result = new ArrayList<>();

        for (int i = 0; i < points.size(); i++) {
            i = switchPoint(result, i);
        }

        this.points = result;
    }

    private int switchPoint(List<Point> result, int index) {
        if (!isLast(index) && points.get(index).getPoint()) {
            result.add(points.get(index +1));
            result.add(points.get(index));
            index ++;
        }

        return index;
    }

    private boolean isLast(int index) {
        return index == points.size() - 1;
    }

    private boolean getLast() {
        return points.get(points.size() - 1).getPoint();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
