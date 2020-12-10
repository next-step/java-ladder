package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final int size;
    private final List<Boolean> steps;

    public Line(List<Boolean> steps) {
        this.steps = steps;
        size = steps.size();
    }

    public Line(int stepCount, LadderGenerateRule ladderGenerateRule) {
        steps = new ArrayList<>();
        size = stepCount;

        for (int i = 0; i < size; i++) {
            Boolean step = !hasBeforeStep(i) && ladderGenerateRule.generate();
            steps.add(step);
        }

    }

    private boolean hasBeforeStep(int index) {
        return index > 0 && steps.get(index - 1);
    }

    public List<Boolean> getSteps() {
        return steps;
    }
}
