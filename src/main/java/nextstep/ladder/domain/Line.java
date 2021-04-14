package nextstep.ladder.domain;

public class Line {
    private final Points points;

    public Line(Points points) {
        this.points = points;
    }

    public Points points() {
        return points;
    }
}