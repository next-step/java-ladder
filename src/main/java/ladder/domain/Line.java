package ladder.domain;

public class Line {

    private Points points;

    private Line(Points points) {

        this.points = points;
    }

    public static Line of(int lineNumber, int height) {

        return new Line(Points.of(height, lineNumber));
    }

    public static Line ofLastLine(int height) {

        return new Line(Points.of(height, false));
    }

    public Points getPoints() {

        return points;
    }
}