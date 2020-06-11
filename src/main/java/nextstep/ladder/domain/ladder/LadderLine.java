package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private List<Point> points;

    LadderLine(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public int size() {
        return points.size();
    }

    boolean getPointStatus(int index) {
        return points.get(index).getCurrentStatus();
    }

    public List<Point> getPoints() {
        return new ArrayList<>(this.points);
    }

    public HorizontalMoveStrategy move(int pointIndex) {
        return this.points.get(pointIndex).move();
    }
}
