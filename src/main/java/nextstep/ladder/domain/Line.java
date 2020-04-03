package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final Person person;
    private final Steps steps;

    private Line(Steps steps, Person person) {
        this.steps = steps;
        this.person = person;
    }

    public static Line last(Person person, int height) {
        List<Step> steps = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            steps.add(Step.of(i, () -> false));
        }

        return new Line(Steps.last(height), person);
    }

    public static Line of(Person person, int height) {
        List<Step> steps = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            steps.add(Step.of(i, new RandomStrategy()));
        }
        return new Line(new Steps(steps, height), person);
    }

    public static Line of(Person person, Line previousLine) {
        Steps previousLineSteps = previousLine.getSteps();
        List<Integer> moveableLinePositions = previousLineSteps.getSteps().stream()
                .filter(step -> !step.isMoveNextLine())
                .map(Step::getPosition)
                .collect(Collectors.toList());
        Steps steps = Steps.of(moveableLinePositions, previousLine.getLineHeight());
        return new Line(steps, person);
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
