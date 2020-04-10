package nextstep.ladder.domain;

import nextstep.ladder.domain.step.Step;
import nextstep.ladder.domain.step.Steps;

public class LadderLine {
    private static final int START_POSITION = 0;

    private final Steps steps;
    private final Person person;

    private LadderLine(Steps steps, Person person) {
        this.steps = steps;
        this.person = person;
    }

    public static LadderLine firstLine(Person person, int height) {
        return new LadderLine(Steps.firstLineSteps(height, START_POSITION), person);
    }

    public static LadderLine middleLine(Person person, Steps previousLineSteps) {
        return new LadderLine(Steps.middleLineSteps(previousLineSteps), person);
    }

    public static LadderLine lastLine(Person person, Steps previousLineSteps) {
        return new LadderLine(Steps.lastLineSteps(previousLineSteps), person);
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
