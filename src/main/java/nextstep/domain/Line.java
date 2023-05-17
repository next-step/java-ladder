package nextstep.domain;

import java.util.List;

public class Line {

    public static final int DOWN = 0;
    public static final int LEFT = -1;
    public static final int RIGHT = 1;

    private final List<Boolean> points;

    public Line(LineCreateStrategy strategy, int peopleCount) {
        this.points = strategy.create(peopleCount - 1);
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public int getDirection(int start) {
        if (start < points.size() && points.get(start)) {
            return RIGHT;
        }

        if (start - 1 >= 0 && points.get(start - 1)) {
            return LEFT;
        }

        return DOWN;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
