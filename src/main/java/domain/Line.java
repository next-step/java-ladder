package domain;

public class Line {
    private final Points points;

    protected Line(final Points points) {
        this.points = points;
    }

    public static Line of(final Length width) {
        Points points = Points.of(width);
        return new Line(points);
    }

    public Points getPoints() {
        return points;
    }

    public Position move(final Position position) {
        return points.movePointAt(position);
    }

}
