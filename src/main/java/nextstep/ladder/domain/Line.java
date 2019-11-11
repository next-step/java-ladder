package nextstep.ladder.domain;

import java.util.List;

public class Line {

    private final Points points;

    public Line(int count) {
        points = new Points(count);
    }

    public List<Point> getPoints() {
        return points.getValue();
    }
}
