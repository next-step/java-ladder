package step2.domain;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public int getSize() {
        return points.size();
    }

    public boolean getPoint(int count) {
        return this.points.get(count);
    }
}
