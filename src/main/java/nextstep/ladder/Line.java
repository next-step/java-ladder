package nextstep.ladder;

import java.util.List;

import static java.util.Collections.*;

public class Line {

    private final List<Boolean> points;

    public Line(int countOfPlayer) {
        this.points = LineGenerator.createLine(countOfPlayer);
    }

    public List<Boolean> getPoints() {
        return unmodifiableList(points);
    }
}
