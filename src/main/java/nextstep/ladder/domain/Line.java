package nextstep.ladder.domain;

import nextstep.ladder.domain.step.Step;
import nextstep.ladder.domain.step.Steps;

public class Line {
    private static final int START_POSITION = 0;

    private final Steps steps;
    private final Person person;

    private Line(Steps steps, Person person) {
        this.steps = steps;
        this.person = person;
    }

    public static Line firstLine(Person person, int height) {
        return new Line(Steps.firstLineSteps(height, START_POSITION), person);
    }

    public static Line middleLine(Person person, Steps previousLineSteps) {
        return new Line(Steps.middleLineSteps(previousLineSteps), person);
    }

    public static Line lastLine(Person person, Steps previousLineSteps) {
        return new Line(Steps.lastLineSteps(previousLineSteps), person);
    }

    public Steps getSteps() {
        return steps;
    }

    public Person getPerson() {
        return person;
    }

    public Step findNextStep(int stepPosition) {
        return steps.get(stepPosition).move();
    }
}
