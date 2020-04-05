package nextstep.ladder.domain.step;

import nextstep.ladder.domain.step.strategy.MovableNext;
import nextstep.ladder.domain.step.strategy.MovableSide;
import nextstep.ladder.domain.step.strategy.MovablePrev;
import nextstep.ladder.domain.step.strategy.MovementRandom;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Steps {
    private final List<Step> steps;
    private final int linePosition;

    public Steps(List<Step> steps, int linePosition) {
        this.steps = steps;
        this.linePosition = linePosition;
    }

    public static Optional<Steps> movableNext(int height, int linePosition) {
        return Optional.ofNullable(
                IntStream.range(0, height)
                        .mapToObj(stepPosition -> Step.of(Bridge.next(linePosition, stepPosition), new MovementRandom()))
                        .collect(Collectors.collectingAndThen(Collectors.toList(), steps-> new Steps(steps, linePosition)))
        );
    }

    public static Optional<Steps> movableBothSideByPreviousCondition(Steps previouSteps) {
        List<Integer> movableStepPositions = previouSteps.findMovablePositions(new MovableNext());
        int height = previouSteps.getLineHeight();
        int currentLinePosition = previouSteps.nextLinePosition();

        return Optional.ofNullable(
                IntStream.range(0, height)
                        .mapToObj(stepPosition ->
                                checkMovableSide(movableStepPositions, Bridge.current(currentLinePosition, stepPosition)))
                        .collect(Collectors.collectingAndThen(Collectors.toList(), steps-> new Steps(steps, currentLinePosition)))
        );
    }

    private static Step checkMovableSide(List<Integer> movableLinePositions, Bridge bridge) {
        if (movableLinePositions.contains(bridge.getStepPosition())) {
            return Step.of(Bridge.next(bridge), new MovementRandom());
        }
        return Step.of(Bridge.previous(bridge), () -> true);
    }

    public static Optional<Steps> movableBothSideByPreviousCondition2(Steps previouSteps) {
        int height = previouSteps.getLineHeight();
        int currentLinePosition = previouSteps.nextLinePosition();

        return Optional.ofNullable(
                IntStream.range(0, height)
                        .mapToObj(stepPosition ->
                                generateMovableBoth2(previouSteps, Bridge.current(currentLinePosition, stepPosition)))
                        .collect(Collectors.collectingAndThen(Collectors.toList(), steps-> new Steps(steps, currentLinePosition)))
        );
    }

    private static Step generateMovableBoth2(Steps previouSteps, Bridge bridge) {
        List<Integer> movablePositions = previouSteps.findMovablePositions(new MovableNext());
        if (movablePositions.contains(bridge.getStepPosition())) {
            return Step.of(Bridge.next(bridge), new MovementRandom());
        }
        return Step.of(Bridge.previous(bridge), () -> true);
    }

    public static Optional<Steps> immovableNext(Steps previouSteps) {
        List<Integer> movableStepPositions = previouSteps.findMovablePositions(new MovablePrev());
        int height = previouSteps.getLineHeight();
        int currentLinePosition = previouSteps.nextLinePosition();

        return Optional.ofNullable(
                IntStream.range(0, height)
                        .mapToObj(stepPosition ->
                                checkMovablePrevious(movableStepPositions, Bridge.current(currentLinePosition, stepPosition)))
                        .collect(Collectors.collectingAndThen(Collectors.toList(), steps-> new Steps(steps, currentLinePosition)))
        );
    }

    private static Step checkMovablePrevious(List<Integer> movableLinePositions, Bridge bridge) {
        if (movableLinePositions.contains(bridge.getStepPosition())) {
            return Step.of(Bridge.previous(bridge), () -> true);
        }
        return Step.of(bridge, () -> false);
    }

    public List<Integer> findMovablePositions(MovableSide movableSide) {
        return steps.stream()
                .filter(previousStep -> movableSide.isMovable(this, previousStep))
                .map(Step::getPosition)
                .collect(Collectors.toList());
    }

    public List<Step> getSteps() {
        return steps;
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
        return linePosition + 1;
    }
}
