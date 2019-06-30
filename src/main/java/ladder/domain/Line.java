package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public int size() {
        return points.size();
    }

    public boolean isLine(int point) {
        return points.get(point);
    }

}
