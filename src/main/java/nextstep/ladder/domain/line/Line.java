package nextstep.ladder.domain.line;

import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.step.Step;
import nextstep.ladder.domain.step.Steps;

import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final Person person;
    private final Steps steps;

    private Line(Steps steps, Person person) {
        this.steps = steps;
        this.person = person;
    }

    public static Line first(Person person, int height) {
        return Steps.movableNext(height, 0)
                .map(steps -> new Line(steps, person))
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public static Line of(Person person, Lines previousLines) {
        Line previousLine = previousLines.lastLine();
        Steps previousLineSteps = previousLine.getSteps();
        List<Integer> moveableStepPositions = previousLineSteps.getSteps().stream()
                .filter(step -> !(step.isMovableLine(previousLines.size())))
                .map(Step::getPosition)
                .collect(Collectors.toList());

        return Steps.movableNextByPreviousCondition(moveableStepPositions, previousLines)
                .map(steps -> new Line(steps, person))
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public static Line last(Person person, Lines previousLines) {
        Line line = previousLines.lastLine();
        line.getLineHeight();
        return Steps.immovableNext(line.getLineHeight(), previousLines.size())
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
