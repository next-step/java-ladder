package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final Points points;

    public Line(Points points) {
        this.points = points;
    }

    public Points points() {
        return this.points;
    }
}
