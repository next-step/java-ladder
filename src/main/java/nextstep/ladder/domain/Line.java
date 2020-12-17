package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int MIN_INDEX = 0;

    private final List<Boolean> steps;

    public Line(int stepCount, LadderGenerateRule ladderGenerateRule) {
        steps = new ArrayList<>();

        for (int i = 0; i < stepCount; i++) {
            Boolean step = !hasBeforeStep(i) && ladderGenerateRule.generate();
            steps.add(step);
        }
    }

    private boolean hasBeforeStep(int index) {
        return index > MIN_INDEX && steps.get(index - 1);
    }

    public List<Boolean> getSteps() {
        return steps;
    }
}
