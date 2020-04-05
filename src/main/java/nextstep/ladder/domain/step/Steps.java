package nextstep.ladder.domain.step;

import nextstep.ladder.domain.step.strategy.RandomMovement;
import nextstep.ladder.domain.step.strategy.StepGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Steps {
    private static final int ONE = 1;

    private final List<Step> steps;
    private final int linePosition;

    public Steps(List<Step> steps, int linePosition) {
        this.steps = Collections.unmodifiableList(steps);
        this.linePosition = linePosition;
    }

    public static Optional<Steps> movableNext(int height, int linePosition) {
        return Optional.ofNullable(
                IntStream.range(0, height)
                        .mapToObj(stepPosition -> Step.of(Bridge.next(linePosition, stepPosition), new RandomMovement()))
                        .collect(Collectors.collectingAndThen(Collectors.toList(), steps -> new Steps(steps, linePosition)))
        );
    }

    public static Optional<Steps> movableByPreviousCondition(Steps previouSteps, StepGenerator stepGenerator) {
        int height = previouSteps.getLineHeight();
        int currentLinePosition = previouSteps.nextLinePosition();

        return Optional.ofNullable(
                IntStream.range(0, height)
                        .mapToObj(stepPosition -> stepGenerator.generate(previouSteps, Bridge.current(currentLinePosition, stepPosition)))
                        .collect(Collectors.collectingAndThen(Collectors.toList(), steps -> new Steps(steps, currentLinePosition)))
        );
    }

    public List<Step> getSteps() {
        return steps;
    }

    public Step get(int index) {
        return steps.get(index);
    }

    public int size() {
        return steps.size();
    }

    public int getLinePosition() {
        return linePosition;
    }

    private int getLineHeight() {
        return steps.size();
    }

    private int nextLinePosition() {
        return linePosition + ONE;
    }
}
