package nextstep.ladder.domain;

import java.util.List;

public class Line {

    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> points() {
        return points;
    }
}
