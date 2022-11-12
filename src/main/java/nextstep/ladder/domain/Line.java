package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final int ZERO = 0;
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int size() {
        return points.size();
    }

    public void checkPointAndChangePosition(Players players) {
        IntStream.range(ZERO, size())
                .filter(point -> points.get(point))
                .forEach(i -> players.changePositions(i));
    }
}
