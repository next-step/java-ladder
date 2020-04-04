package nextstep.ladder.domain.step;

import nextstep.ladder.domain.line.Lines;

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
                        .mapToObj(stepPosition -> Step.of(Bridge.next(linePosition, stepPosition), new RandomStrategy()))
                        .collect(Collectors.collectingAndThen(Collectors.toList(), steps-> new Steps(steps, linePosition)))
        );
    }

    public static Optional<Steps> movableNextByPreviousCondition(List<Integer> movableLinePositions, Lines previouLines) {
        int height = previouLines.lineHeight();
        int linePosition = previouLines.size();
        return Optional.ofNullable(
                IntStream.range(0, height)
                        .mapToObj(stepPosition -> checkMovable(movableLinePositions, Bridge.current(linePosition, stepPosition)))
                        .collect(Collectors.collectingAndThen(Collectors.toList(), steps-> new Steps(steps, linePosition)))
        );
    }

    public static Optional<Steps> movableNextByPreviousCondition(List<Integer> movableLinePositions, Steps previouSteps) {
        int height = previouSteps.getLineHeight();
        int linePosition = previouSteps.linePosition + 1;

        return Optional.ofNullable(
                IntStream.range(0, height)
                        .mapToObj(stepPosition -> checkMovable(movableLinePositions, Bridge.current(linePosition, stepPosition)))
                        .collect(Collectors.collectingAndThen(Collectors.toList(), steps-> new Steps(steps, linePosition)))
        );
    }

    private static Step checkMovable(List<Integer> movableLinePositions, Bridge bridge) {
        if (movableLinePositions.contains(bridge.getStepPosition())) {
            return Step.of(Bridge.next(bridge), new RandomStrategy());
        }
        return Step.of(Bridge.previous(bridge), () -> true);
    }

    public static Optional<Steps> immovableNext(List<Integer> movableLinePositions, Steps previouSteps) {
        int height = previouSteps.getLineHeight();
        int linePosition = previouSteps.linePosition + 1;

        return Optional.ofNullable(
                IntStream.range(0, height)
                        .mapToObj(stepPosition -> checkMovablePrevious(movableLinePositions, Bridge.current(linePosition, stepPosition)))
                        .collect(Collectors.collectingAndThen(Collectors.toList(), steps-> new Steps(steps, linePosition)))
        );
    }

    private static Step checkMovablePrevious(List<Integer> movableLinePositions, Bridge bridge) {
        if (movableLinePositions.contains(bridge.getStepPosition())) {
            return Step.of(Bridge.previous(bridge), () -> true);
        }
        return Step.of(bridge, () -> false);
    }

    public List<Step> getSteps() {
        return steps;
    }

    public int getLinePosition() {
        return linePosition;
    }

    private int getLineHeight() {
        return steps.size();
    }
}
