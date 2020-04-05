package nextstep.ladder.domain;

import nextstep.ladder.domain.step.Steps;
import nextstep.ladder.domain.step.strategy.StepGenerator;

public class Line {
    private static final int START_POSITION = 0;

    private final Person person;
    private final Steps steps;

    private Line(Steps steps, Person person) {
        this.steps = steps;
        this.person = person;
    }

    public static Line first(Person person, int height) {
        return Steps.movableNext(height, START_POSITION)
                .map(steps -> new Line(steps, person))
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public static Line of(Person person, Steps previousLineSteps, StepGenerator stepGenerator) {
        return Steps.movableByPreviousCondition(previousLineSteps, stepGenerator)
                .map(steps -> new Line(steps, person))
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public int getLineHeight() {
        return steps.size();
    }

    public Steps getSteps() {
        return steps;
    }

    public Person getPerson() {
        return person;
    }
}
