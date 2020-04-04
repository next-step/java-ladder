package nextstep.ladder;

import java.util.List;

public class Line {
    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Point> getValue() {
        return this.points;
    }
}
