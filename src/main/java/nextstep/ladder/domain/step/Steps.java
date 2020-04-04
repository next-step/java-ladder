package nextstep.ladder.domain.step;

import nextstep.ladder.domain.line.Lines;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Steps {
    private final List<Step> steps;
    private final int height;

    public Steps(List<Step> steps, int height) {
        this.steps = steps;
        this.height = height;
    }

    public static Optional<Steps> movableNext(int height, int linePosition) {
        return Optional.ofNullable(
                IntStream.range(0, height)
                        .mapToObj(stepPosition -> Step.of(Bridge.next(linePosition, stepPosition), new RandomStrategy()))
                        .collect(Collectors.collectingAndThen(Collectors.toList(), steps-> new Steps(steps, height)))
        );
    }

    public static Optional<Steps> movableNextByPreviousCondition(List<Integer> movableLinePositions, Lines previouLines) {
        int height = previouLines.lastLine().getLineHeight();
        return Optional.ofNullable(
                IntStream.range(0, height)
                        .mapToObj(stepPosition -> checkMovableStep(movableLinePositions, Bridge.current(previouLines.size(), stepPosition)))
                        .collect(Collectors.collectingAndThen(Collectors.toList(), steps-> new Steps(steps, height)))
        );
    }

    private static Step checkMovableStep(List<Integer> movableLinePositions, Bridge bridge) {
        if (movableLinePositions.contains(bridge.getStepPosition())) {
            return Step.of(Bridge.next(bridge), new RandomStrategy());
        }
        return Step.of(Bridge.previous(bridge), () -> true);
    }

    public static Optional<Steps> immovableNext(int height, int linePosition) {
        return Optional.ofNullable(
                IntStream.range(0, height)
                .mapToObj(stepPosition -> Step.of(Bridge.previous(linePosition, stepPosition), () -> false))
                .collect(Collectors.collectingAndThen(Collectors.toList(), steps-> new Steps(steps, height)))
        );
    }

    public List<Step> getSteps() {
        return steps;
    }
}
