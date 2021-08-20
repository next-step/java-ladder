package nextstep.ladder.domain.ladder;

import nextstep.ladder.application.RandomCreatePoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ColumnLine {
    private List<Point> points = new ArrayList<>();
    private Result result = new Result();

    public ColumnLine(Height height) {
        initPoints(height.getValue());
    }

    public ColumnLine(List<Direction> pointOfDirection) {
        points = pointOfDirection.stream()
                .map(direction -> new Point(direction))
                .collect(Collectors.toList());
    }

    public ColumnLine(Height height, String result) {
        initPoints(height.getValue());
        this.result = new Result(result);
    }

    private ColumnLine() {}

    private void initPoints(int height) {
        for (int i = 0; i < height; i++) {
            points.add(new Point(Direction.NONE));
        }
    }

    public void draw(ColumnLine nextColumnLine) {
        for (int index = 0; index < points.size()-1; index++) {
            points.get(index).drawRightLine(nextColumnLine.getPointOfHeight(index),RandomCreatePoint.of());
        }
    }

    public Point getPointOfHeight(int heightIndex) {
        return points.get(heightIndex);
    }

    public List<Point> getPoints() {
        return points;
    }

    public Direction getPointOfDirection(int height) {
        return points.get(height).getDirection();
    }

    public String getResult() {
        return result.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnLine that = (ColumnLine) o;
        return Objects.equals(points, that.points) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, result);
    }
}
