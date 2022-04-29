package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    public Line(int countOfPlayer) {
        this.points = LineGenerator.createLine(countOfPlayer);
    }

    public List<Boolean> getPoints() {
        return new ArrayList<>(points);
    }
}
