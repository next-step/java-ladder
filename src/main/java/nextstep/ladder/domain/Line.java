package nextstep.ladder.domain;

import nextstep.ladder.domain.step.RandomStrategy;
import nextstep.ladder.domain.step.Step;
import nextstep.ladder.domain.step.Steps;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final Person person;
    private final Steps steps;

    private Line(Steps steps, Person person) {
        this.steps = steps;
        this.person = person;
    }

    public static Line first(Person person, int height) {
        return Steps.movableNext(height)
                .map(steps -> new Line(steps, person))
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public static Line of(Person person, Line previousLine) {
        Steps previousLineSteps = previousLine.getSteps();
        List<Integer> moveableLinePositions = previousLineSteps.getSteps().stream()
                .filter(step -> !step.isMoveNextLine())
                .map(Step::getPosition)
                .collect(Collectors.toList());
        int lineHeight = previousLine.getLineHeight();

        return Steps.movableNextByPreviousCondition(moveableLinePositions, lineHeight)
                .map(steps -> new Line(steps, person))
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public static Line last(Person person, int height) {
        return Steps.immovableNext(height)
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
