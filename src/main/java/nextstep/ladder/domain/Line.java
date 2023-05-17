package nextstep.ladder.domain;

import nextstep.ladder.domain.util.DrawStrategy;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    private List<Step> steps;

    public Line(List<Step> steps) {
        this.steps = steps;
    }

    public static Line draw(int numberOfParticipants, DrawStrategy drawStrategy) {
        List<Step> steps = new ArrayList<>();

        Step step = drawFirstStep(steps, drawStrategy);

        step = drawNextStep(numberOfParticipants, drawStrategy, steps, step);

        drawLastStep(steps, step);

        return new Line(steps);
    }

    private static Step drawFirstStep(List<Step> steps, DrawStrategy drawStrategy) {
        Step step = Step.firstStep(drawStrategy.drawFirstPosition());
        steps.add(step);

        return step;
    }

    private static Step drawNextStep(int numberOfParticipants, DrawStrategy drawStrategy, List<Step> steps, Step step) {
        int beforeLastIndex = numberOfParticipants - 1;

        for (int i = SECOND_INDEX; i < beforeLastIndex; i++) {
            step = step.nextStep(drawStrategy.drawNextPosition(step));
            steps.add(step);
        }

        return step;
    }

    private static void drawLastStep(List<Step> steps, Step step) {
        steps.add(step.lastStep());
    }

    public int numberOfSteps() {
        return steps.size();
    }

    public List<Position> stepsToPositions() {
        List<Position> positions = new ArrayList<>();

        for (int i = FIRST_INDEX; i < steps.size(); i++) {
            positions.add(new Position(i, steps.get(i)));
        }

        return positions;
    }

    public List<Position> stepsToPositions(Results results) {
        List<Position> positions = new ArrayList<>();

        for (int i = FIRST_INDEX; i < steps.size(); i++) {
            int matchedKey = results.matchedKeyOfValue(i);
            positions.add(new Position(results.getValue(matchedKey), steps.get(i)));
        }

        return positions;
    }

    public List<Step> getSteps() {
        return steps;
    }
}
