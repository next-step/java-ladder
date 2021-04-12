package ladder.domain;

import java.util.List;

public final class Line {

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static final Line of(List<Boolean> points) {
        return new Line(points);
    }

}
