package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points;

    Line(List<Boolean> points) {
        this.points = new ArrayList<>(points);
    }

    public int size() {
        return points.size();
    }

    public boolean getPointsIndex(int index) {
        return points.get(index);
    }

    public List<Boolean> getPointsValue() {
        return new ArrayList<>(this.points);
    }
}
