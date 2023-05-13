package nextstep.ladder.domain;

import nextstep.ladder.domain.util.DrawStrategy;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Step> steps;

    private Line(List<Step> steps) {
        this.steps = steps;
    }

    public static Line draw(int numberOfParticipants, DrawStrategy drawStrategy) {
        List<Step> steps = new ArrayList<>();

        Step step = Step.firstStep(drawStrategy.drawFirstPosition());
        steps.add(step);

        for (int i = 1; i < numberOfParticipants; i++) {
            step = step.nextStep(drawStrategy.drawNextPosition(step));
            steps.add(step);
        }

        return new Line(steps);
    }

    public int numberOfSteps() {
        return steps.size();
    }
}
