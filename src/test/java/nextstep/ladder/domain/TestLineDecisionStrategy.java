package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TestLineDecisionStrategy implements LineDecisionStrategy {
    private final Queue<Boolean> decisions;

    public TestLineDecisionStrategy(Boolean... decisions) {
        this.decisions = new LinkedList<>(Arrays.asList(decisions));
    }

    @Override
    public boolean shouldDrawLine() {
        return !decisions.isEmpty() && decisions.poll();
    }
}
