package nextstep.ladder.domain.line;

import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.step.Step;
import nextstep.ladder.domain.step.Steps;

import java.util.List;
import java.util.stream.Collectors;

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

    public static Line of(Person person, Steps previousLineSteps) {
        List<Integer> moveableStepPositions = previousLineSteps.getSteps().stream()
                .filter(previousStep -> !previousStep.isMovableLine(previousLineSteps.getLinePosition() + 1))
                .map(Step::getPosition)
                .collect(Collectors.toList());

        return Steps.movableNextByPreviousCondition(moveableStepPositions, previousLineSteps)
                .map(steps -> new Line(steps, person))
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public static Line last(Person person, Steps previousLineSteps) {
        List<Integer> moveableStepPositions = previousLineSteps.getSteps().stream()
                .filter(previousStep -> previousStep.isMovableLine(previousLineSteps.getLinePosition() + 1))
                .map(Step::getPosition)
                .collect(Collectors.toList());
        return Steps.immovableNext(moveableStepPositions, previousLineSteps)
                .map(steps -> new Line(steps, person))
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public int getLineHeight() {
        return steps.getSteps().size();
    }

    public Steps getSteps() {
        return steps;
    }

    public Person getPerson() {
        return person;
    }
}
