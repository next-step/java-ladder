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

    private Boolean createLine(int index, BooleanStrategy booleanStrategy) {
        if (isPrev(index)) {
            return false;
        }
        return booleanStrategy.decide(index);
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

    public int decide(int index) {
        if (isLeft(index)) {
            return index - 1;
        }
        if (isRight(index)) {
            return index + 1;
        }
        return index;
    }

    private boolean isLeft(int result) {
        if (result == 0 || !lines.get(result - 1)) {
            return false;
        }
        return true;
    }

    private boolean isRight(int result) {
        if (lines.size() == result || !lines.get(result)) {
            return false;
        }
        return true;
    }

}
