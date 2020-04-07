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
        return new Line(Steps.movableNext(height, START_POSITION), person);
    }

    public static Line of(Person person, Steps previousLineSteps, StepGenerator stepGenerator) {
        return new Line(Steps.movableByPreviousCondition(previousLineSteps, stepGenerator), person);
    }

    public Steps getSteps() {
        return steps;
    }

    public Person getPerson() {
        return person;
    }
}
