package ladder.domain;

import java.util.List;

public class LadderLine {
    private final List<Boolean> points;

    public LadderLine(List<Boolean> points) {
        this.points = points;
    }

    public int move(int startPosition) {
        if (points.get(startPosition)) {
            return startPosition + 1;
        }

        if (points.get(startPosition - 1)) {
            return startPosition - 1;
        }

        return startPosition;
    }
}
