package nextstep.ladder.domain;

import nextstep.ladder.domain.step.Steps;
import nextstep.ladder.domain.step.strategy.MovablePrevAndNext;
import nextstep.ladder.domain.step.strategy.MovablePrev;

import java.util.Objects;

public class Line {
    private static final int START_POSITION = 0;

    private final Steps steps;
    private final Person person;

    private Line(Steps steps, Person person) {
        this.steps = steps;
        this.person = person;
    }

    public static Line firstLine(Person person, int height) {
        return new Line(Steps.movableNext(height, START_POSITION), person);
    }

    public static Line middleLine(Person person, Steps previousLineSteps) {
        return new Line(Steps.movableByPreviousCondition(previousLineSteps, new MovablePrevAndNext()), person);
    }

    public static Line lastLine(Person person, Steps previousLineSteps) {
        return new Line(Steps.movableByPreviousCondition(previousLineSteps, new MovablePrev()), person);
    }

    public Steps getSteps() {
        return steps;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(steps, line.steps) &&
                Objects.equals(person, line.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(steps, person);
    }
}
