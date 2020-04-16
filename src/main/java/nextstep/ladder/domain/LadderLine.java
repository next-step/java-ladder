package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLine {
    private final List<ImprovingPoint> points;

    public LadderLine(List<ImprovingPoint> points) {
        this.points = Collections.unmodifiableList(new ArrayList<>(points));
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public List<ImprovingPoint> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "LadderLine{" +
               "points=" + points +
               '}';
    }
}
