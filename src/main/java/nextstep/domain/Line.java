package nextstep.domain;

import java.util.List;

public class Line {

    private final List<Boolean> points;

    public Line(LineCreateStrategy strategy, int peopleCount) {
        this.points = strategy.create(peopleCount - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
