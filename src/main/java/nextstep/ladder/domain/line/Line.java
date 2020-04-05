package nextstep.ladder.domain.line;

import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.step.strategy.MovableNextStrategy;
import nextstep.ladder.domain.step.strategy.MovablePrevStrategy;
import nextstep.ladder.domain.step.Steps;

import java.util.List;

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
        List<Integer> movableStepPositions = previousLineSteps.findMovablePositions(new MovableNextStrategy());
        return Steps.movableBothSideByPreviousCondition(movableStepPositions, previousLineSteps)
                .map(steps -> new Line(steps, person))
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public static Line last(Person person, Steps previousLineSteps) {
        List<Integer> movableStepPositions = previousLineSteps.findMovablePositions(new MovablePrevStrategy());
        return Steps.immovableNext(movableStepPositions, previousLineSteps)
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
