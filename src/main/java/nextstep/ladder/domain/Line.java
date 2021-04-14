package nextstep.ladder.domain;

public class Line {
    private final int index;
    private final Points points;

    public Line(int index, Points points) {
        this.index = index;
        this.points = points;
    }

    public Points points() {
        return points;
    }

    public int index() {
        return index;
    }

    public boolean isNotLast(int totalSize) {
        return index != totalSize - 1;
    }

    public int nextPointIndexFrom(int pointIndex) {
        Point point = points.findByIndex(pointIndex);
        return point.move();
    }
}