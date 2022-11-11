package game.domain.ladder;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> points() {
        return points;
    }
}
