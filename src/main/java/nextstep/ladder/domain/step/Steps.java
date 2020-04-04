package nextstep.ladder.domain.step;

import java.util.ArrayList;
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

    public static Optional<Steps> movableNextByPreviousCondition(List<Integer> movableLinePositions, int height) {
        return Optional.ofNullable(
                IntStream.range(0, height)
                        .mapToObj(i -> checkMovableStep(movableLinePositions, i))
                        .collect(Collectors.collectingAndThen(Collectors.toList(), steps-> new Steps(steps, height)))
        );
    }

    private static Step checkMovableStep(List<Integer> movableLinePositions, int i) {
        if (movableLinePositions.contains(i)) {
            return Step.of(i, new RandomStrategy());
        }
        return Step.of(i, () -> false);
    }

    public static Optional<Steps> immovableNext(int height) {
        return Optional.ofNullable(
                IntStream.range(0, height)
                .mapToObj(i -> Step.of(i, () -> false))
                .collect(Collectors.collectingAndThen(Collectors.toList(), steps-> new Steps(steps, height)))
        );
    }

    public static Optional<Steps> movableNext(int height) {
        return Optional.ofNullable(IntStream.range(0, height)
                .mapToObj(i -> Step.of(i, new RandomStrategy()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), steps-> new Steps(steps, height)))
        );
    }

    public List<Step> getSteps() {
        return steps;
    }

    public Step get(int index) {
        return steps.get(index);
    }

    public int getHeight() {
        return height;
    }
}
