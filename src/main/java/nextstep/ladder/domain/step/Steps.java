package nextstep.ladder.domain.step;

import java.util.ArrayList;
import java.util.List;

public class Steps {
    private final List<Step> steps;
    private final int height;

    public Steps(List<Step> steps, int height) {
        this.steps = steps;
        this.height = height;
    }

    public static Steps of(List<Integer> movableLinePositions, int height) {
        List<Step> steps = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Step step = Step.of(i, () -> false);
            if (movableLinePositions.contains(i)) {
                step = Step.of(i, new RandomStrategy());
            }
            steps.add(step);
        }
        return new Steps(steps, height);
    }

    public static Steps last(int height) {
        List<Step> steps = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Step step = Step.of(i, () -> false);
            steps.add(step);
        }
        return new Steps(steps, height);
    }

    public List<Step> getSteps() {
        return steps;
    }

    public int getHeight() {
        return height;
    }
}
