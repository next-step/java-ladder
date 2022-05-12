package ladder.domain.step;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public class Steps {
    private final List<Step> steps;

    public Steps() {
        this(emptyList());
    }

    public Steps(List<Step> steps) {
        validate(steps);
        this.steps = new ArrayList<>(steps);
    }

    private void validate(List<Step> steps) {
        if (steps == null) {
            throw new IllegalArgumentException("steps는 null 일 수 없습니다.");
        }
    }

    public boolean lastIsCrossable() {
        if (steps.isEmpty()) {
            return false;
        }

        return lastStep().isCrossable();
    }

    private Step lastStep() {
        return steps.get(steps.size() - 1);
    }

    public Steps extend(Step step) {
        if (lastIsCrossable() && step.isCrossable()) {
            throw new IllegalArgumentException("step은 연속으로 건널 수 없습니다.");
        }

        List<Step> steps = new ArrayList<>(this.steps);
        steps.add(step);
        return new Steps(steps);
    }

    public int size() {
        return steps.size();
    }

    public List<Step> getSteps() {
        return steps;
    }
}
