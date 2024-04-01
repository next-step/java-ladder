package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Points {

    private final List<Boolean> points;

    public Points(List<Boolean> points) {
        this.points = points;
    }

    public void add(Boolean point) {
        points.add(point);
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
