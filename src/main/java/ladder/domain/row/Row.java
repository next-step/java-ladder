package ladder.domain.row;

import ladder.domain.step.Step;

import java.util.ArrayList;
import java.util.List;

public class Row {
    static final int ROW_START_INDEX = 1;

    private final List<Step> steps;

    public Row(List<Step> steps) {
        validate(steps);
        this.steps = new ArrayList<>(steps);
    }

    private void validate(List<Step> steps) {
        if (steps == null) {
            throw new IllegalArgumentException("steps는 null 일 수 없습니다.");
        }
    }

    public static Row from(int rowSize) {
        List<Step> steps = new ArrayList<>();
        steps.add(Step.first());

        for (int i = ROW_START_INDEX; i < rowSize - 1; i++) {
            steps.add(
                    Step.from(lastStep(steps))
            );
        }
        return new Row(steps);
    }

    private static Step lastStep(List<Step> steps) {
        return steps.get(steps.size() - 1);
    }

    public List<Step> getSteps() {
        return steps;
    }
}
