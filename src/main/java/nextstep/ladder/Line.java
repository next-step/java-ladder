package nextstep.ladder;

import nextstep.ladder.strategy.LadderStrategy;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final boolean NOT_CREATABLE_LADDER = false;

    private final List<Boolean> points = new ArrayList<>();

    public Line() {
    }

    public void addLine(LadderStrategy strategy) {
        boolean previousPoint = NOT_CREATABLE_LADDER;
        if (!points.isEmpty()) {
            previousPoint = points.get(points.size() - 1);
        }
        if (previousPoint) {
            points.add(NOT_CREATABLE_LADDER);
            return;
        }

        points.add(strategy.creatable());
    }

    public Boolean getPointStatus(int index) {
        return points.get(index);
    }
}
