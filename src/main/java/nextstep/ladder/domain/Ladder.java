package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BooleanStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Boolean> lines = new ArrayList<>();

    public Ladder(int lineCount, BooleanStrategy booleanStrategy) {
        for (int i = 0; i < lineCount; i++) {
            lines.add(createLine(i, booleanStrategy));
        }
    }

    private Boolean createLine(int i, BooleanStrategy booleanStrategy) {
        if (isPrev(i)) {
            return false;
        }
        return booleanStrategy.decide();
    }

    private boolean isPrev(int i) {
        if (i == 0) {
            return false;
        }
        return lines.get(i - 1);
    }

    public List<Boolean> getLines() {
        return lines;
    }
}
